package com.gestionmaquinitas.GestionMaquinas.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventarioDTO {
    private Long id;

    private String nombre;
    private Integer stock;
}
