package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.TiendaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService implements ITiendaService{

    @Override
    public List<TiendaDTO> getTiendas() {
        return List.of();
    }

    @Override
    public TiendaDTO createTienda(TiendaDTO tiendaDTO) {
        return null;
    }

    @Override
    public TiendaDTO updateTienda(Long id, TiendaDTO tiendaDTO) {
        return null;
    }

    @Override
    public void deleteTienda(Long id) {

    }
}
