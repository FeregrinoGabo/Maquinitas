package com.gestionmaquinitas.GestionMaquinas.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
