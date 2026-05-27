package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.MaquinaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.MaquinaDTO;
import com.gestionmaquinitas.GestionMaquinas.model.Maquina;

import java.util.List;

public interface IMaquinaService {
    List<MaquinaDTO> getMaquina();
    MaquinaDTO getOneMaquina(Long id);
    Maquina getOneMaquinaEntity(Long id);
    MaquinaDTO createMaquina(MaquinaRequestDTO maquinaRequestDTO);
    MaquinaDTO updateMaquina(Long id, MaquinaRequestDTO maquinaRequestDTO);
    void deleteMaquina(Long id);
}
