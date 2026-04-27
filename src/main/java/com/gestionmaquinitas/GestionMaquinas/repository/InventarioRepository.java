package com.gestionmaquinitas.GestionMaquinas.repository;

import com.gestionmaquinitas.GestionMaquinas.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
