package com.gestionmaquinitas.GestionMaquinas.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gestionmaquinitas.GestionMaquinas.dto.request.AsignacionRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.AsignacionDTO;
import com.gestionmaquinitas.GestionMaquinas.model.Asignacion;

import java.util.List;

public interface IAsignacionService {
    List<AsignacionDTO> getAsignacion();
    AsignacionDTO getOneAsignacion(Long id);
    Asignacion getOneAsignacionEntity (Long id);
    AsignacionDTO createAsignacion (AsignacionRequestDTO asignacionRequestDTO);
    AsignacionDTO updateAsignacion (AsignacionRequestDTO asignacionRequestDTO, Long id);
    void deleteAsignacion(Long id);
}
