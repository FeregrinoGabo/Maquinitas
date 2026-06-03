package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.MaquinaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.MaquinaDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import com.gestionmaquinitas.GestionMaquinas.model.Maquina;
import com.gestionmaquinitas.GestionMaquinas.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaquinaService implements IMaquinaService{

    @Autowired
    MaquinaRepository maquinaRepository;

    @Autowired
    EmpresaService empresaService;

    @Override
    public List<MaquinaDTO> getMaquina() {
        return maquinaRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public MaquinaDTO getOneMaquina (Long id){
        return maquinaRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado la maquina con el id: " + id
        ));
    }

    @Override
    public Maquina getOneMaquinaEntity(Long id){
        return maquinaRepository.findById(id).orElseThrow(() -> new NotFoundException("Maquina con el id: " + id +
                " no se ha encontrado"));
    }

    @Override
    public MaquinaDTO createMaquina(MaquinaRequestDTO maquinaRequestDTO) {
        Empresa empresa = empresaService.getOneEmpresaEntity(maquinaRequestDTO.getEmpresaId());

        Maquina maquina = MapperEntity.toEntity(maquinaRequestDTO);
        maquina.setEmpresa(empresa);

        Maquina maquinaGuardar = maquinaRepository.save(maquina);

        return MapperDTO.toDTO(maquinaGuardar);
    }

    @Override
    public MaquinaDTO updateMaquina(Long id, MaquinaRequestDTO maquinaRequestDTO) {
        Maquina maquina = maquinaRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado la maquina. Maquina con id: " + id
        ));

        maquina.setColor(maquinaRequestDTO.getColor());
        maquina.setCapacidad(maquinaRequestDTO.getCapacidad());
        maquina.setEstado(maquinaRequestDTO.getEstado());
        maquina.setDescripcion(maquinaRequestDTO.getDescripcion());
        maquina.setEmpresa(empresaService.getOneEmpresaEntity(maquinaRequestDTO.getEmpresaId()));

        return MapperDTO.toDTO(maquinaRepository.save(maquina));
    }

    @Override
    public void deleteMaquina(Long id) {
        maquinaRepository.deleteById(id);
    }
}
