package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EntradaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EntradaDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Entrada;
import com.gestionmaquinitas.GestionMaquinas.model.Inventario;
import com.gestionmaquinitas.GestionMaquinas.model.Usuario;
import com.gestionmaquinitas.GestionMaquinas.repository.EntradaRepository;
import com.gestionmaquinitas.GestionMaquinas.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class EntradaService implements IEntradaService{

    @Autowired
    EntradaRepository entradaRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    InventarioRepository inventarioRepository;
    @Autowired
    InventarioService inventarioService;

    @Override
    public List<EntradaDTO> getEntrada() {
        return entradaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public EntradaDTO getOneEntrada(Long id) {
        return entradaRepository.findById(id).map(MapperDTO::toDTO).orElse(null);
    }

    @Override
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
    public EntradaDTO updateEntrada(Long id, EntradaRequestDTO entradaRequestDTO) {
        return null;
    }

    @Override
    public void deleteEntrada(Long id) {
        entradaRepository.deleteById(id);
    }
}
