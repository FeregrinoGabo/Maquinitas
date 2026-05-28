package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.TiendaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.TiendaDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import com.gestionmaquinitas.GestionMaquinas.model.Tienda;
import com.gestionmaquinitas.GestionMaquinas.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService implements ITiendaService{

    @Autowired
    TiendaRepository tiendaRepository;
    @Autowired
    EmpresaService empresaService;

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
    public TiendaDTO createTienda(TiendaRequestDTO tiendaRequestDTO) {
        Empresa empresa = empresaService.getOneEmpresaEntity(tiendaRequestDTO.getEmpresaId());

        Tienda tienda = MapperEntity.toEntity(tiendaRequestDTO);
        tienda.setFechaRetiro(null);
        tienda.setEmpresa(empresa);

        Tienda tiendaGuardar = tiendaRepository.save(tienda);
        return MapperDTO.toDTO(tiendaGuardar);
    }

    @Override
    public TiendaDTO updateTienda(Long id, TiendaRequestDTO tiendaRequestDTO) {
        return null;
    }

    @Override
    public void deleteTienda(Long id) {
        tiendaRepository.deleteById(id);
    }
}
