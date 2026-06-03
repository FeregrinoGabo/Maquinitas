package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.TiendaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.TiendaDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import com.gestionmaquinitas.GestionMaquinas.model.Tienda;
import com.gestionmaquinitas.GestionMaquinas.repository.TiendaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiendaService implements ITiendaService{

    private final TiendaRepository tiendaRepository;
    private final EmpresaService empresaService;

    @Override
    public List<TiendaDTO> getTiendas() {
        return tiendaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public TiendaDTO getOneTienda(Long id) {
        return tiendaRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "No se a encontrado la tienda con el id: " + id
        ));
    }

    @Override
    public Tienda getOneTiendaEntity(Long id){
        return tiendaRepository.findById(id).orElseThrow(() -> new NotFoundException("La tienda con el id: " + id +
                " no se ha encontrado"));
    }

    @Override
    @Transactional
    public TiendaDTO createTienda(TiendaRequestDTO tiendaRequestDTO) {
        Empresa empresa = empresaService.getOneEmpresaEntity(tiendaRequestDTO.getEmpresaId());

        Tienda tienda = MapperEntity.toEntity(tiendaRequestDTO);
        tienda.setFechaRetiro(null);
        tienda.setEmpresa(empresa);

        Tienda tiendaGuardar = tiendaRepository.save(tienda);
        return MapperDTO.toDTO(tiendaGuardar);
    }

    @Override
    @Transactional
    public TiendaDTO updateTienda(Long id, TiendaRequestDTO tiendaRequestDTO) {
        Tienda tienda = tiendaRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado la tienda a actualizar. Tienda con ID: " + id
        ));

        tienda.setNombre(tiendaRequestDTO.getNombre());
        tienda.setPais(tiendaRequestDTO.getPais());
        tienda.setEstado(tiendaRequestDTO.getEstado());
        tienda.setMunicipio(tiendaRequestDTO.getMunicipio());
        tienda.setColonia(tiendaRequestDTO.getColonia());
        tienda.setPorcentajeBase(tiendaRequestDTO.getPorcentajeBase());
        tienda.setEmpresa(empresaService.getOneEmpresaEntity(tiendaRequestDTO.getEmpresaId()));

        return MapperDTO.toDTO(tiendaRepository.save(tienda));
    }

    @Override
    @Transactional
    public void deleteTienda(Long id) {
        Tienda eliminarTienda = tiendaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha" +
                " encontrado la tienda o no existe. Tienda con ID: " + id));
        tiendaRepository.delete(eliminarTienda);
    }
}
