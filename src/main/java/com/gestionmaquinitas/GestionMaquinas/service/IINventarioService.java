package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.InventarioDTO;

import java.util.List;

public interface IINventarioService {
    List<InventarioDTO> getInventario();
    //Aqui se agrego este metodo, dado que si los inventarios son grandes, seguro que será neceario poder obtener uno
    // en especifico
    InventarioDTO getOneInventario(Long id);
    InventarioDTO createInventario(InventarioDTO inventarioDTO);
    InventarioDTO updateInventario(Long id, InventarioDTO inventarioDTO);
    void deleteInventario(Long id);
}
