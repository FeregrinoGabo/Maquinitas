package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EmpresaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EmpresaDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import com.gestionmaquinitas.GestionMaquinas.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService implements IEmpresaService{

    private final EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDTO> getEmpresa() {
        return empresaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public Empresa getOneEmpresaEntity (Long id) {
        return empresaRepository.findById(id).orElseThrow(() -> new NotFoundException("Empresa no " +
                "encontrada con id: " + id));
    }

    @Override
    public EmpresaDTO getEmpresaById (Long id){
        return empresaRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado la empresa con el id: " + id
        ));
    }

    @Override
    @Transactional
    public EmpresaDTO createEmpresa(EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = MapperEntity.toEntity(empresaRequestDTO);

        Empresa empresaGuardada = empresaRepository.save(empresa);

        return MapperDTO.toDTO(empresaGuardada);
    }

    @Override
    @Transactional
    public EmpresaDTO updateEmpresa(Long id, EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No se encontro la empresa. Empresa con ID: " + id
        ));

        empresa.setNombre(empresaRequestDTO.getNombre());

        return MapperDTO.toDTO(empresaRepository.save(empresa));
    }

    @Override
    @Transactional
    public void deleteEmpresa(Long id) {
        Empresa eliminarEmpresa = empresaRepository.findById(id).orElseThrow(() -> new NotFoundException("La " +
                "empresa no se ha encontrado o no existe. Empresa con ID: " + id));
        empresaRepository.delete(eliminarEmpresa);
    }
}
