package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.UsuarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.UsuarioDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperEntity;
import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import com.gestionmaquinitas.GestionMaquinas.model.RolUsuario;
import com.gestionmaquinitas.GestionMaquinas.model.Usuario;
import com.gestionmaquinitas.GestionMaquinas.repository.EmpresaRepository;
import com.gestionmaquinitas.GestionMaquinas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EmpresaService empresaService;

    @Override
    public List<UsuarioDTO> getUsuario() {
        return usuarioRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public UsuarioDTO getOneUsuario(Long id){
        return usuarioRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado el usuario con el id: " + id
        ));
    }

    @Override
    public Usuario getOneUsuarioEntity (Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("El usuario con el ID: " +
                id + " no fue encontrado"));
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Empresa empresa = empresaService.getOneEmpresaEntity(usuarioRequestDTO.getEmpresaId());

        Usuario usuario = MapperEntity.toEntity(usuarioRequestDTO);
        usuario.setRol(RolUsuario.GENERAL);
        usuario.setFechaRetiro(null);
        usuario.setEmpresa(empresa);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return MapperDTO.toDTO(usuarioGuardado);
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
