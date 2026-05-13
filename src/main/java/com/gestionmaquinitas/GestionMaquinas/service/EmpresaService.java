package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.EmpresaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements IEmpresaService{

    @Override
    public List<EmpresaDTO> getEmpresa() {
        return List.of();
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
