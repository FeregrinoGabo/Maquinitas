package com.gestionmaquinitas.GestionMaquinas.dto.response;

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
