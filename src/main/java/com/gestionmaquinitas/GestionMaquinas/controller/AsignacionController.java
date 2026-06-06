package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.AsignacionRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.AsignacionDTO;
import com.gestionmaquinitas.GestionMaquinas.service.IAsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/asignaciones")
public class AsignacionController {

    private final IAsignacionService iAsignacionService;

    @GetMapping
    public ResponseEntity<List<AsignacionDTO>> getAsignacion() {
        return ResponseEntity.ok(iAsignacionService.getAsignacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDTO> getOneAsignacion(@PathVariable Long id){
        return ResponseEntity.ok(iAsignacionService.getOneAsignacion(id));
    }

    @PostMapping
    public ResponseEntity<AsignacionDTO> createAsignacion(@RequestBody AsignacionRequestDTO asignacionRequestDTO){
        AsignacionDTO asignacionCreadaDTO = iAsignacionService.createAsignacion(asignacionRequestDTO);

        return ResponseEntity.created(URI.create("api/asignaciones/" + asignacionCreadaDTO.getId()))
                .body(asignacionCreadaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionDTO> updateAsignacion(@PathVariable Long id,
                                                          @RequestBody AsignacionRequestDTO asignacionRequestDTO){
        return ResponseEntity.ok(iAsignacionService.updateAsignacion(asignacionRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsignacion(@PathVariable Long id){
        iAsignacionService.deleteAsignacion(id);
        return ResponseEntity.noContent().build();
    }

}
