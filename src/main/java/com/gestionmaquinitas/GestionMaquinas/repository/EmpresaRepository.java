package com.gestionmaquinitas.GestionMaquinas.repository;

import com.gestionmaquinitas.GestionMaquinas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
