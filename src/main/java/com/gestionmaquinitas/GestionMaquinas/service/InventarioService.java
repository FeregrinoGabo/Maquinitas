package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.InventarioDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IINventarioService{

    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public List<InventarioDTO> getInventario() {
        return inventarioRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public InventarioDTO getOneInventario(Long id) {
        return inventarioRepository.findById(id).map(MapperDTO::toDTO).orElse(null);
    }

    @Override
    public InventarioDTO createInventario(InventarioDTO inventarioDTO) {
        return null;
    }

    @Override
    public InventarioDTO updateInventario(Long id, InventarioDTO inventarioDTO) {
        return null;
    }

    @Override
    public void deleteInventario(Long id) {

    }
}
