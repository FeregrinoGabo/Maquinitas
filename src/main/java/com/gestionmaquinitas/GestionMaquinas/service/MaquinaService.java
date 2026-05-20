package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.MaquinaDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinaService implements IMaquinaService{

    @Autowired
    MaquinaRepository maquinaRepository;

    @Override
    public List<MaquinaDTO> getMaquina() {
        return maquinaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
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
