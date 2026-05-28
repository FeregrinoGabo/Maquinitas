package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.InventarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.InventarioDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import com.gestionmaquinitas.GestionMaquinas.model.Inventario;
import com.gestionmaquinitas.GestionMaquinas.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IINventarioService{

    @Autowired
    InventarioRepository inventarioRepository;
    @Autowired
    EmpresaService empresaService;

    @Override
    public List<InventarioDTO> getInventario() {
        return inventarioRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public InventarioDTO getOneInventario(Long id) {
        return inventarioRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado el inventario con el id: " + id
        ));
    }

    @Override
    public Inventario getOneInventarioEntity(Long id){
        return inventarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Inventario con id: " + id +
                " no se ha encontrado"));
    }

    @Override
    public InventarioDTO createInventario(InventarioRequestDTO inventarioRequestDTO) {
        Empresa empresa = empresaService.getOneEmpresaEntity(inventarioRequestDTO.getEmpresaId());

        Inventario inventario = MapperEntity.toEntity(inventarioRequestDTO);
        inventario.setEmpresa(empresa);

        Inventario inventarioGuardado = inventarioRepository.save(inventario);
        return MapperDTO.toDTO(inventarioGuardado);
    }

    @Override
    public InventarioDTO updateInventario(Long id, InventarioRequestDTO inventarioRequestDTO) {
        return null;
    }

    @Override
    public void deleteInventario(Long id) {
        inventarioRepository.deleteById(id);
    }
}
