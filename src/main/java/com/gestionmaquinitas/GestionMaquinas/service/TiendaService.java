package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.TiendaDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService implements ITiendaService{

    @Autowired
    TiendaRepository tiendaRepository;

    @Override
    public List<TiendaDTO> getTiendas() {
        return tiendaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
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
