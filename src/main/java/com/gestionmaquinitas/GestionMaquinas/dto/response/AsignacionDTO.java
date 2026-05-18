package com.gestionmaquinitas.GestionMaquinas.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignacionDTO {
    private Long id;
    private LocalDateTime fechaAsignacion;
    private LocalDateTime fechaRetiro;

    private String nombreUsuario;
    private String nombreTienda;
    private Long idMaquina;
}
