package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.InventarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IINventarioService{
    @Override
    public List<InventarioDTO> getInventario() {
        return List.of();
    }

    @Override
    public InventarioDTO getOneInventario(Long id) {
        return null;
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
