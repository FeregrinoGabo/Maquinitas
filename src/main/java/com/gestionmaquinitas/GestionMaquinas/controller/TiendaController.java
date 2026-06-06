package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.TiendaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.TiendaDTO;
import com.gestionmaquinitas.GestionMaquinas.service.ITiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/tiendas")
public class TiendaController {

    private final ITiendaService iTiendaService;

    @GetMapping
    public ResponseEntity<List<TiendaDTO>> getTienda(){
        return ResponseEntity.ok(iTiendaService.getTiendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> getOneTienda(@PathVariable Long id){
        return ResponseEntity.ok(iTiendaService.getOneTienda(id));
    }

    @PostMapping
    public ResponseEntity<TiendaDTO> createTienda(@RequestBody TiendaRequestDTO tiendaRequestDTO){
        TiendaDTO tiendaCreada = iTiendaService.createTienda(tiendaRequestDTO);

        return ResponseEntity.created(URI.create("api/tiendas/" + tiendaCreada.getId())).body(tiendaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TiendaDTO> updateTienda(@PathVariable Long id,
                                                  @RequestBody TiendaRequestDTO tiendaRequestDTO){
        return ResponseEntity.ok(iTiendaService.updateTienda(id, tiendaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTienda(@PathVariable Long id){
        iTiendaService.deleteTienda(id);
        return ResponseEntity.noContent().build();
    }
}
