package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EntradaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EntradaDTO;

import java.util.List;

public interface IEntradaService {
    List<EntradaDTO> getEntrada();
    EntradaDTO getOneEntrada(Long id);
    EntradaDTO createEntrada(EntradaRequestDTO entradaRequestDTO);
    EntradaDTO updateEntrada(Long id, EntradaRequestDTO entradaRequestDTO);
    void deleteEntrada(Long id);

}
