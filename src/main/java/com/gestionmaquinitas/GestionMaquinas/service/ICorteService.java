package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.CorteRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.CorteDTO;

import java.util.List;

public interface ICorteService {
    List<CorteDTO> getCorte();
    CorteDTO getOneCorte(Long id);
    CorteDTO createCorte(CorteRequestDTO corteRequestDTO);
    CorteDTO updateCorte(Long id, CorteRequestDTO corteRequestDTO);
    void deleteCorte(Long id);
}
