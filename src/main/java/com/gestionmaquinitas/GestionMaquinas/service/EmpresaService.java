package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.EmpresaDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDTO> getEmpresa() {
        return empresaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public EmpresaDTO createEmpresa(EmpresaDTO empresaDTO) {
        return null;
    }

    @Override
    public EmpresaDTO updateEmpresa(Long id, EmpresaDTO empresaDTO) {
        return null;
    }

    @Override
    public void deleteEmpresa(Long id) {

    }
}
