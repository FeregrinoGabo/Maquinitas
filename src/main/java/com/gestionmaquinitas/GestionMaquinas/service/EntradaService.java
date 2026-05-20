package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EntradaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EntradaDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EntradaService implements IEntradaService{

    @Autowired
    EntradaRepository entradaRepository;

    @Override
    public List<EntradaDTO> getEntrada() {
        return entradaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public EntradaDTO getOneEntrada(Long id) {
        return null;
    }

    @Override
    public EntradaDTO createEntrada(EntradaRequestDTO entradaRequestDTO) {
        return null;
    }

    @Override
    public EntradaDTO updateEntrada(Long id, EntradaRequestDTO entradaRequestDTO) {
        return null;
    }

    @Override
    public void deleteEntrada(Long id) {

    }
}
