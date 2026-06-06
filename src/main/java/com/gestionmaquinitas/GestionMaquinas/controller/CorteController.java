package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.CorteRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.CorteDTO;
import com.gestionmaquinitas.GestionMaquinas.service.ICorteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/cortes")
public class CorteController {

    private final ICorteService iCorteService;

    @GetMapping
    public ResponseEntity<List<CorteDTO>> getCorte(){

        return ResponseEntity.ok(iCorteService.getCorte());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorteDTO> getOneCorte(@PathVariable Long id){

        return ResponseEntity.ok(iCorteService.getOneCorte(id));
    }

    @PostMapping
    public ResponseEntity<CorteDTO> createCorte(@RequestBody CorteRequestDTO corteRequestDTO){
        CorteDTO corteCreadaDTO = iCorteService.createCorte(corteRequestDTO);

        return ResponseEntity.created(URI.create("api/cortes/" + corteCreadaDTO.getId())).body(corteCreadaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CorteDTO> updateCorte(@PathVariable Long id,
                                                    @RequestBody CorteRequestDTO corteRequestDTO){

        return ResponseEntity.ok(iCorteService.updateCorte(id, corteRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorte(@PathVariable Long id){
        iCorteService.deleteCorte(id);
        return ResponseEntity.noContent().build();
    }
}
