package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EmpresaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EmpresaDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
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
    public Empresa getOneEmpresaEntity (Long id) {
        return empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa no " +
                "encontrada con id: " + id));
    }

    @Override
    public EmpresaDTO getEmpresaById (Long id){
        return empresaRepository.findById(id).map(MapperDTO::toDTO).orElse(null);
    }

    @Override
    public EmpresaDTO createEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = MapperEntity.toEntity(empresaRequestDTO);

        Empresa empresaGuardada = empresaRepository.save(empresa);

        return MapperDTO.toDTO(empresaGuardada);
    }

    @Override
    public EmpresaDTO updateEmpresa(Long id, EmpresaDTO empresaDTO) {
        return null;
    }

    @Override
    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
