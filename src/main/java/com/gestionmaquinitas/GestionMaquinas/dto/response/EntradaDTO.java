package com.gestionmaquinitas.GestionMaquinas.dto.response;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EntradaDTO {
    private Long id;

    private Integer cantidad;
    private BigDecimal costo;
    private String descripcion;
    private LocalDateTime fechaLlegada;

    private Long idEncargado;
}
