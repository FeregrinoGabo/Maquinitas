package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.CorteDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.repository.CorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorteService implements ICorteService{

    @Autowired
    CorteRepository corteRepository;

    @Override
    public CorteDTO getCorte(Long id) {
        return corteRepository.findById(id).map(MapperDTO::toDTO).orElse(null);
    }

    @Override
    public CorteDTO createCorte(CorteDTO corteDTO) {
        return null;
    }

    @Override
    public CorteDTO updateCorte(Long id, CorteDTO corteDTO) {
        return null;
    }

    @Override
    public void deleteCorte(Long id) {

    }
}
