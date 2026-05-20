package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.UsuarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.UsuarioDTO;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.model.Usuario;
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
        return usuarioRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    public UsuarioDTO getOneUsuario(Long id){
        return usuarioRepository.findById(id).map(MapperDTO::toDTO).orElse(null);
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioRequestDTO usuarioDTO) {

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
