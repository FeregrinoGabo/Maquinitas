package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.CorteDTO;

public interface ICorteService {
    CorteDTO getCorte(Long id);
    CorteDTO createCorte(CorteDTO corteDTO);
    CorteDTO updateCorte(Long id, CorteDTO corteDTO);
    void deleteCorte(Long id);
}
