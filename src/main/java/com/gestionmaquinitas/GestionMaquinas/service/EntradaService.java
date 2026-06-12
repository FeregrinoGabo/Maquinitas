package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EntradaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EntradaDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Entrada;
import com.gestionmaquinitas.GestionMaquinas.model.Inventario;
import com.gestionmaquinitas.GestionMaquinas.model.Usuario;
import com.gestionmaquinitas.GestionMaquinas.repository.EntradaRepository;
import com.gestionmaquinitas.GestionMaquinas.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntradaService implements IEntradaService{

    private final EntradaRepository entradaRepository;
    private final UsuarioService usuarioService;
    private final InventarioRepository inventarioRepository;
    private final InventarioService inventarioService;

    @Override
    public List<EntradaDTO> getEntrada() {
        return entradaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public EntradaDTO getOneEntrada(Long id) {
        return entradaRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado la entrada con el id: " + id
        ));
    }

    @Override
    @Transactional
    public EntradaDTO createEntrada(EntradaRequestDTO entradaRequestDTO) {
        Inventario inventario = inventarioService.getOneInventarioEntity(entradaRequestDTO.getIdInventario());

        // la fromula que se usará para el promedio nuevo es el siguiente
        // ((Stock Actual * Costo Promedio Actual) + (Cantidad Nueva * Costo Nuevo)) / (Stock Actual + Cantidad Nueva)
        BigDecimal stockActual = new BigDecimal(inventario.getStock() !=null ? inventario.getStock() : 0);
        BigDecimal costoPromedioActual = inventario.getCostoPromedio() !=null ?
                inventario.getCostoPromedio() : BigDecimal.ZERO;
        BigDecimal cantidadNueva = new BigDecimal(entradaRequestDTO.getCantidad());
        BigDecimal costoNuevo = entradaRequestDTO.getCosto();

        BigDecimal promedioActual = stockActual.multiply(costoPromedioActual);
        BigDecimal promedioNuevo = cantidadNueva.multiply(costoNuevo);
        BigDecimal stockTotal = stockActual.add(cantidadNueva);

        BigDecimal nuevoCostopPromedio = promedioActual.add(promedioNuevo)
                .divide(stockTotal, 2, RoundingMode.HALF_UP);

        inventario.setStock(stockTotal.intValue());
        inventario.setCostoPromedio(nuevoCostopPromedio);
        inventarioRepository.save(inventario);

        Usuario encargado = usuarioService.getOneUsuarioEntity(entradaRequestDTO.getIdEncargado());

        Entrada entrada = MapperEntity.toEntity(entradaRequestDTO);
        entrada.setInventario(inventario);
        entrada.setEncargado(encargado);

        Entrada entradaGuardada = entradaRepository.save(entrada);

        return MapperDTO.toDTO(entradaGuardada);
    }

    @Override
    @Transactional
    public EntradaDTO updateEntrada(Long id, EntradaRequestDTO entradaRequestDTO) {
        Entrada entrada = entradaRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado la entrada. Entrada con ID: " + id
        ));

        Inventario inventarioViejo = entrada.getInventario();
        if (inventarioViejo != null) {
            BigDecimal stockViejo = new BigDecimal(inventarioViejo.getStock() != null ? inventarioViejo.getStock() : 0);
            BigDecimal costoPromedioViejo = inventarioViejo.getCostoPromedio() != null ? inventarioViejo.getCostoPromedio() :
                    BigDecimal.ZERO;

            BigDecimal cantidadVieja = new BigDecimal(entrada.getCantidad());
            BigDecimal valorRestar = entrada.getCosto();

            BigDecimal valorTotalViejo = stockViejo.multiply(costoPromedioViejo);
            BigDecimal nuevoStockViejo = stockViejo.subtract(cantidadVieja);
            BigDecimal nuevoCostoPromedioViejo = BigDecimal.ZERO;

            if (nuevoStockViejo.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal nuevoValorTotalViejo = valorTotalViejo.subtract(valorRestar);
                nuevoCostoPromedioViejo = nuevoValorTotalViejo.divide(nuevoStockViejo, 2, RoundingMode.HALF_UP);
            }

            inventarioViejo.setStock(nuevoStockViejo.intValue());
            inventarioViejo.setCostoPromedio(nuevoCostoPromedioViejo);
            inventarioRepository.save(inventarioViejo);
        }

        Inventario inventarioNuevo = inventarioService.getOneInventarioEntity(entradaRequestDTO.getIdInventario());

        BigDecimal stockActualNuevo = new BigDecimal(inventarioNuevo.getStock() != null ? inventarioNuevo.getStock() : 0);
        BigDecimal costoPromedioActualNuevo = inventarioNuevo.getCostoPromedio() != null ? inventarioNuevo.getCostoPromedio() : BigDecimal.ZERO;

        BigDecimal cantidadNueva = new BigDecimal(entradaRequestDTO.getCantidad());
        BigDecimal costoNuevo = entradaRequestDTO.getCosto(); // Costo total nuevo del DTO

        BigDecimal valorTotalActualNuevo = stockActualNuevo.multiply(costoPromedioActualNuevo);
        BigDecimal stockTotalNuevo = stockActualNuevo.add(cantidadNueva);

        BigDecimal nuevoCostoPromedioActual = BigDecimal.ZERO;
        if (stockTotalNuevo.compareTo(BigDecimal.ZERO) > 0) {
            nuevoCostoPromedioActual = valorTotalActualNuevo.add(costoNuevo)
                    .divide(stockTotalNuevo, 2, RoundingMode.HALF_UP);
        }

        inventarioNuevo.setStock(stockTotalNuevo.intValue());
        inventarioNuevo.setCostoPromedio(nuevoCostoPromedioActual);
        inventarioRepository.save(inventarioNuevo);

        entrada.setCantidad(entradaRequestDTO.getCantidad());
        entrada.setCosto(entradaRequestDTO.getCosto());
        entrada.setDescripcion(entradaRequestDTO.getDescripcion());
        entrada.setEncargado(usuarioService.getOneUsuarioEntity(entradaRequestDTO.getIdEncargado()));
        entrada.setInventario(inventarioService.getOneInventarioEntity(entradaRequestDTO.getIdInventario()));

        return MapperDTO.toDTO(entradaRepository.save(entrada));
    }

    @Override
    @Transactional
    public void deleteEntrada(Long id) {
        Entrada eliminarEntrada = entradaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha " +
                "encontrado la entrada o no existe. Entrada con ID: " + id));

        Inventario inventario = eliminarEntrada.getInventario();
        if (inventario != null) {
            BigDecimal stockActual = new BigDecimal(inventario.getStock() != null ? inventario.getStock() : 0);
            BigDecimal promedioActual = inventario.getCostoPromedio() != null ? inventario.getCostoPromedio() :
                    BigDecimal.ZERO;

            BigDecimal stockEliminar = new BigDecimal(eliminarEntrada.getCantidad());
            BigDecimal costoEliminar = eliminarEntrada.getCosto();

            BigDecimal costoActual = stockActual.multiply(promedioActual);

            BigDecimal cantidadRestante = stockActual.subtract(stockEliminar);
            BigDecimal nuevoCostoPromedio = BigDecimal.ZERO;

            if (cantidadRestante.compareTo(BigDecimal.ZERO) > 0) {
                BigDecimal cantidadEliminar = costoActual.subtract(costoEliminar);
                nuevoCostoPromedio = cantidadEliminar.divide(cantidadRestante, 2, RoundingMode.HALF_UP);
            }

            inventario.setStock(cantidadRestante.intValue());
            inventario.setCostoPromedio(nuevoCostoPromedio);
        }
        entradaRepository.delete(eliminarEntrada);
    }
}
