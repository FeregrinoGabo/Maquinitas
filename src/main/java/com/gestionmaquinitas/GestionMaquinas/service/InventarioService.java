package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.InventarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.InventarioDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import com.gestionmaquinitas.GestionMaquinas.model.Inventario;
import com.gestionmaquinitas.GestionMaquinas.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventarioService implements IINventarioService{

    private final InventarioRepository inventarioRepository;
    private final EmpresaService empresaService;

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
    @Transactional
    public InventarioDTO createInventario(InventarioRequestDTO inventarioRequestDTO) {
        Empresa empresa = empresaService.getOneEmpresaEntity(inventarioRequestDTO.getEmpresaId());

        Inventario inventario = MapperEntity.toEntity(inventarioRequestDTO);
        inventario.setEmpresa(empresa);

        Inventario inventarioGuardado = inventarioRepository.save(inventario);
        return MapperDTO.toDTO(inventarioGuardado);
    }

    @Override
    @Transactional
    public InventarioDTO updateInventario(Long id, InventarioRequestDTO inventarioRequestDTO) {
        Inventario inventario = inventarioRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "El inventario no se ha encontrado. Inventario con id: " + id
        ));

        inventario.setNombre(inventarioRequestDTO.getNombre());
        inventario.setStock(inventarioRequestDTO.getStock());
        inventario.setEmpresa(empresaService.getOneEmpresaEntity(inventarioRequestDTO.getEmpresaId()));

        return MapperDTO.toDTO(inventarioRepository.save(inventario));
    }

    @Override
    @Transactional
    public void deleteInventario(Long id) {
        Inventario eliminarInventario = inventarioRepository.findById(id).orElseThrow(() -> new NotFoundException("No " +
                "se ha encontrado el Inventario o no existe. Inventario con ID: " + id));
        inventarioRepository.delete(eliminarInventario);
    }
}
