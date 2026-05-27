package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.MaquinaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.MaquinaDTO;
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
        return maquinaRepository.findById(id).map(MapperDTO::toDTO).orElse(null);
    }

    @Override
    public Maquina getOneMaquinaEntity(Long id){
        return maquinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Maquina con el id: " + id +
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
        return null;
    }

    @Override
    public void deleteMaquina(Long id) {
        maquinaRepository.deleteById(id);
    }
}
