package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.TiendaDTO;

import java.util.List;

public interface ITiendaService {

    //Este será mi primer metodo, planeo hacer con todas las interfaces los metodos CRUD

    //Lectura
    List<TiendaDTO> getTiendas();
    //Crear
    TiendaDTO createTienda(TiendaDTO tiendaDTO);
    //Actualizar
    TiendaDTO updateTienda(Long id, TiendaDTO tiendaDTO);
    //Eliminar
    void deleteTienda(Long id);
}
