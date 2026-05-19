package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.UsuarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> getUsuario ();
    UsuarioDTO createUsuario(UsuarioRequestDTO usuarioDTO);
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO);
    void deleteUsuario(Long id);
}
