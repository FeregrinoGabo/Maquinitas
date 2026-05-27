package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.InventarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.InventarioDTO;
import com.gestionmaquinitas.GestionMaquinas.model.Inventario;

import java.util.List;

public interface IINventarioService {
    List<InventarioDTO> getInventario();
    InventarioDTO getOneInventario(Long id);
    Inventario getOneInventarioEntity(Long id);
    InventarioDTO createInventario(InventarioRequestDTO inventarioRequestDTO);
    InventarioDTO updateInventario(Long id, InventarioRequestDTO inventarioRequestDTO);
    void deleteInventario(Long id);
}
