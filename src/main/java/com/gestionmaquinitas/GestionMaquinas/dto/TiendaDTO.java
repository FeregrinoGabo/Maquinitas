package com.gestionmaquinitas.GestionMaquinas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class TiendaDTO {
    private Long id;

    private String nombre;
    private String pais;
    private String estado;
    private String municipio;
    private String colonia;
    private Integer porcentajeBase;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaRetiro;
}
