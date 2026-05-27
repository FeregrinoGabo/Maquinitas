package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.UsuarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.UsuarioDTO;
import com.gestionmaquinitas.GestionMaquinas.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> getUsuario ();
    UsuarioDTO getOneUsuario (Long id);
    Usuario getOneUsuarioEntity (Long id);
    UsuarioDTO createUsuario(UsuarioRequestDTO usuarioDTO);
    UsuarioDTO updateUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO);
    void deleteUsuario(Long id);
}
