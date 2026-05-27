package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.TiendaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.TiendaDTO;
import com.gestionmaquinitas.GestionMaquinas.model.Tienda;

import java.util.List;

public interface ITiendaService {

    //Este será mi primer metodo, planeo hacer con todas las interfaces los metodos CRUD

    //Lectura
    List<TiendaDTO> getTiendas();
    TiendaDTO getOneTienda (Long id);
    Tienda getOneTiendaEntity (Long id);
    //Crear
    TiendaDTO createTienda(TiendaRequestDTO tiendaRequestDTO);
    //Actualizar
    TiendaDTO updateTienda(Long id, TiendaRequestDTO tiendaRequestDTO);
    //Eliminar
    void deleteTienda(Long id);
}
