package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.UsuarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.UsuarioDTO;
import com.gestionmaquinitas.GestionMaquinas.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final IUsuarioService iUsuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuario(){
        return ResponseEntity.ok(iUsuarioService.getUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getOneUsuario(@PathVariable Long id){
        return ResponseEntity.ok(iUsuarioService.getOneUsuario(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioDTO usuarioCreado = iUsuarioService.createUsuario(usuarioRequestDTO);

        return ResponseEntity.created(URI.create("api/usuarios/" + usuarioCreado.getId())).body(usuarioCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id,
                                                    @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok(iUsuarioService.updateUsuario(id, usuarioRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        iUsuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
