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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final EmpresaService empresaService;

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
    @Transactional
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
    @Transactional
    public UsuarioDTO updateUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("El usuario que se " +
                "desea actualizar no se encuentra. Usuario con id: " + id));

        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setApellidoMaterno(usuarioRequestDTO.getApellidoMaterno());
        usuario.setApellidoPaterno(usuarioRequestDTO.getApellidoPaterno());
        usuario.setUsername(usuarioRequestDTO.getUsername());
        usuario.setRol(usuarioRequestDTO.getRol());
        usuario.setEmpresa(empresaService.getOneEmpresaEntity(usuarioRequestDTO.getEmpresaId()));

        return MapperDTO.toDTO(usuarioRepository.save(usuario));
    }

    @Override
    @Transactional
    public void deleteUsuario(Long id) {
        Usuario eliminarUsuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("El usuario " +
                "que se desea eliminar no se encuentra o no existe. Usuario con ID: " + id));
        usuarioRepository.delete(eliminarUsuario);
    }
}
