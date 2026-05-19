package com.gestionmaquinitas.GestionMaquinas.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InventarioDTO {
    private Long id;

    private String nombre;
    private Integer stock;
    private BigDecimal costoPromedio;
}
