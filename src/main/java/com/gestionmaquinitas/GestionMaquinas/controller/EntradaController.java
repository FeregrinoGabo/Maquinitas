package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EntradaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EntradaDTO;
import com.gestionmaquinitas.GestionMaquinas.service.IEntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/entradas")

public class EntradaController {

    private final IEntradaService iEntradaService;

    @GetMapping
    public ResponseEntity<List<EntradaDTO>> getEntrada() {
        return ResponseEntity.ok(iEntradaService.getEntrada());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaDTO> getOneEntrada(@PathVariable Long id){
        return ResponseEntity.ok(iEntradaService.getOneEntrada(id));
    }

    @PostMapping
    public ResponseEntity<EntradaDTO> createEntrada(@RequestBody EntradaRequestDTO entradaRequestDTO){
        EntradaDTO entradaCreadaDTO = iEntradaService.createEntrada(entradaRequestDTO);

        return ResponseEntity.created(URI.create("api/entradas/" + entradaCreadaDTO.getId()))
                .body(entradaCreadaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaDTO> updateEntrada(@PathVariable Long id,
                                                          @RequestBody EntradaRequestDTO entradaRequestDTO){
        return ResponseEntity.ok(iEntradaService.updateEntrada(id, entradaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id){
        iEntradaService.deleteEntrada(id);
        return ResponseEntity.noContent().build();
    }
}
