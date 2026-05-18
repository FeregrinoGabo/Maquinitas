package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.MaquinaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinaService implements IMaquinaService{

    @Override
    public List<MaquinaDTO> getMaquina() {
        return List.of();
    }

    @Override
    public MaquinaDTO createMaquina(MaquinaDTO maquinaDTO) {
        return null;
    }

    @Override
    public MaquinaDTO updateMaquina(Long id, MaquinaDTO maquinaDTO) {
        return null;
    }

    @Override
    public void deleteMaquina(Long id) {

    }
}
