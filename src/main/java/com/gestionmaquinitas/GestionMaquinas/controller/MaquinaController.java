package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.MaquinaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.MaquinaDTO;
import com.gestionmaquinitas.GestionMaquinas.service.IMaquinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/maquinas")
public class MaquinaController {

    private final IMaquinaService iMaquinaService;

    @GetMapping
    public ResponseEntity<List<MaquinaDTO>> getMaquina(){
        return ResponseEntity.ok(iMaquinaService.getMaquina());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaquinaDTO> getOneMaquina(@PathVariable Long id){
        return ResponseEntity.ok(iMaquinaService.getOneMaquina(id));
    }

    @PostMapping
    public ResponseEntity<MaquinaDTO> createMaquina(@RequestBody MaquinaRequestDTO maquinaRequestDTO){
        MaquinaDTO maquinaCreada = iMaquinaService.createMaquina(maquinaRequestDTO);

        return ResponseEntity.created(URI.create("api/maquinas/" + maquinaCreada.getId())).body(maquinaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaquinaDTO> updateMaquina(@PathVariable Long id,
                                                    @RequestBody MaquinaRequestDTO maquinaRequestDTO) {
        return ResponseEntity.ok(iMaquinaService.updateMaquina(id, maquinaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMauina(@PathVariable Long id){
        iMaquinaService.deleteMaquina(id);
        return ResponseEntity.noContent().build();
    }
}
