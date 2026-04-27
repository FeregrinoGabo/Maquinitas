package com.gestionmaquinitas.GestionMaquinas.repository;

import com.gestionmaquinitas.GestionMaquinas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
