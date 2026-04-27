package com.gestionmaquinitas.GestionMaquinas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

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
