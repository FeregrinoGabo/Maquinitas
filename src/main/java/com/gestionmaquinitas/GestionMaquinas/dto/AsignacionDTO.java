package com.gestionmaquinitas.GestionMaquinas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class AsignacionDTO {
    private Long id;
    private LocalDateTime fechaAsignacion;
    private LocalDateTime fechaRetiro;

    private String nombreUsuario;
    private String nombreTienda;
    private Long idMaquina;
}
