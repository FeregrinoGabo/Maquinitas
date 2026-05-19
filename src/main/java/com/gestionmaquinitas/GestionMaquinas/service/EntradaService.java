package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EntradaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EntradaDTO;

import java.util.List;

public class EntradaService implements IEntradaService{
    @Override
    public List<EntradaDTO> getEntrada() {
        return List.of();
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
