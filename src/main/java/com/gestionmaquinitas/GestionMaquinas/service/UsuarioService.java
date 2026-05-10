package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{
    @Override
    public List<UsuarioDTO> getUsuario() {
        return List.of();
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
