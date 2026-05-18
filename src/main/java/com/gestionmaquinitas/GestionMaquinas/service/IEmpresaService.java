package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.response.EmpresaDTO;

import java.util.List;

public interface IEmpresaService {
    //No se como debe funcionar los metodos de Empresa, dado que una persona solo puede tener una,a menos
    // que se permita tener mas de una, que debe ser posible
    List<EmpresaDTO> getEmpresa();
    EmpresaDTO createEmpresa(EmpresaDTO empresaDTO);
    EmpresaDTO updateEmpresa(Long id, EmpresaDTO empresaDTO);
    void deleteEmpresa(Long id);
}
