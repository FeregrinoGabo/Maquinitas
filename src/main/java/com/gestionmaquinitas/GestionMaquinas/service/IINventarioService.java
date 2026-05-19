package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.InventarioDTO;

import java.util.List;

public interface IINventarioService {
    List<InventarioDTO> getInventario();
    InventarioDTO getOneInventario(Long id);
    InventarioDTO createInventario(InventarioDTO inventarioDTO);
    InventarioDTO updateInventario(Long id, InventarioDTO inventarioDTO);
    void deleteInventario(Long id);
}
