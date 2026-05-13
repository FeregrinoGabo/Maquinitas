package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.UsuarioDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.Mapper;
import com.gestionmaquinitas.GestionMaquinas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getUsuario() {
        return usuarioRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        return null;
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {

    }
}
