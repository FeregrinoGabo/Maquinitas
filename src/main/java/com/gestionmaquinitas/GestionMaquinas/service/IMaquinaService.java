package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.MaquinaDTO;

import java.util.List;

public interface IMaquinaService {
    List<MaquinaDTO> getMaquina();
    MaquinaDTO createMaquina(MaquinaDTO maquinaDTO);
    MaquinaDTO updateMaquina(Long id, MaquinaDTO maquinaDTO);
    void deleteMaquina(Long id);
}
