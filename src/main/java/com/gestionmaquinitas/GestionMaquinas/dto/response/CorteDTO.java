package com.gestionmaquinitas.GestionMaquinas.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CorteDTO {
    private Long id;

    private BigDecimal dineroRecolectado;
    private LocalDateTime fechaCorte;
    private Integer peluchesRestantes;
    private Integer porcentajePactado;
    private BigDecimal costoPorPeluche;
    private Integer recargaPeluches;

    private Long idUsuario;
    private String nombreUsuario;
    private String usernameUsuario;

    private Long idAsignacion;
    private Long idMaquina;

    private Long idTienda;
    private String nombreTienda;
}
