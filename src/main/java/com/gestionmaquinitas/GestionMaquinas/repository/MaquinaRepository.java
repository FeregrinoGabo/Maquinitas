package com.gestionmaquinitas.GestionMaquinas.repository;

import com.gestionmaquinitas.GestionMaquinas.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
}
