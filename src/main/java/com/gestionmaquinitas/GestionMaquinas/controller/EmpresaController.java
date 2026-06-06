package com.gestionmaquinitas.GestionMaquinas.controller;

import com.gestionmaquinitas.GestionMaquinas.dto.request.EmpresaRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.EmpresaDTO;
import com.gestionmaquinitas.GestionMaquinas.service.IEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/empresas")
public class EmpresaController {

    public final IEmpresaService iEmpresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> getEmpresa(){

        return ResponseEntity.ok(iEmpresaService.getEmpresa());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> getOneEmpresa(@PathVariable Long id){

        return ResponseEntity.ok(iEmpresaService.getOneEmpresa(id));
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> createEmpresa(@RequestBody EmpresaRequestDTO empresaRequestDTO){
        EmpresaDTO empresaCreadaDTO = iEmpresaService.createEmpresa(empresaRequestDTO);

        return ResponseEntity.created(URI.create("api/empresas/" + empresaCreadaDTO.getId())).body(empresaCreadaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> updateEmpresa(@PathVariable Long id,
                                                    @RequestBody EmpresaRequestDTO empresaRequestDTO){

        return ResponseEntity.ok(iEmpresaService.updateEmpresa(id, empresaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id){
        iEmpresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
