package com.gestionmaquinitas.GestionMaquinas.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gestionmaquinitas.GestionMaquinas.dto.request.CorteRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.CorteDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Asignacion;
import com.gestionmaquinitas.GestionMaquinas.model.Corte;
import com.gestionmaquinitas.GestionMaquinas.model.Usuario;
import com.gestionmaquinitas.GestionMaquinas.repository.CorteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorteService implements ICorteService{

    @Autowired
    CorteRepository corteRepository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    AsignacionService asignacionService;

    @Override
    public CorteDTO getOneCorte(Long id) {
        return corteRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado el corte con el id: " + id
        ));
    }

    @Override
    public CorteDTO createCorte(CorteRequestDTO corteRequestDTO) {
        Usuario usuario = usuarioService.getOneUsuarioEntity(corteRequestDTO.getIdUsuario());
        Asignacion asignacion = asignacionService.getOneAsignacionEntity(corteRequestDTO.getIdAsignacion());

        Corte corte = MapperEntity.toEntity(corteRequestDTO);
        corte.setUsuario(usuario);
        corte.setAsignacion(asignacion);

        Corte corteGuardado = corteRepository.save(corte);

        return MapperDTO.toDTO(corteGuardado);
    }

    @Override
    public CorteDTO updateCorte(Long id, CorteRequestDTO corteRequestDTO) {
        Corte corte = corteRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No se encontro el corte. Corte con ID: " + id
        ));

        corte.setDineroRecolectado(corteRequestDTO.getDineroRecolectado());
        corte.setPeluchesRestantes(corteRequestDTO.getPeluchesRestantes());
        corte.setPorcentajePactado(corteRequestDTO.getPorcentajePactado());
        corte.setRecargaPeluches(corteRequestDTO.getRecargaPeluches());
        corte.setUsuario(usuarioService.getOneUsuarioEntity(corteRequestDTO.getIdUsuario()));
        corte.setAsignacion(asignacionService.getOneAsignacionEntity(corteRequestDTO.getIdAsignacion()));

        return MapperDTO.toDTO(corteRepository.save(corte));
    }

    @Override
    public void deleteCorte(Long id) {
        corteRepository.deleteById(id);
    }
}
