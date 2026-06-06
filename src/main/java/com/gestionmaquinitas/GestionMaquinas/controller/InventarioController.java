package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.InventarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.InventarioDTO;
import com.gestionmaquinitas.GestionMaquinas.repository.InventarioRepository;
import com.gestionmaquinitas.GestionMaquinas.service.IINventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/inventarios")
public class InventarioController {

    private final IINventarioService iiNventarioService;

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> getInventario(){
        return ResponseEntity.ok(iiNventarioService.getInventario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> getOneInventario(@PathVariable Long id){
        return ResponseEntity.ok(iiNventarioService.getOneInventario(id));
    }

    @PostMapping
    public ResponseEntity<InventarioDTO> createInventario(@RequestBody InventarioRequestDTO inventarioRequestDTO){
        InventarioDTO inventarioCreado = iiNventarioService.createInventario(inventarioRequestDTO);

        return ResponseEntity.created(URI.create("api/inventarios/" + inventarioCreado.getId())).body(inventarioCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> updateInventario(@PathVariable Long id,
                                                          @RequestBody InventarioRequestDTO inventarioRequestDTO){
        return ResponseEntity.ok(iiNventarioService.updateInventario(id, inventarioRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id){
        iiNventarioService.deleteInventario(id);
        return ResponseEntity.noContent().build();
    }
}
