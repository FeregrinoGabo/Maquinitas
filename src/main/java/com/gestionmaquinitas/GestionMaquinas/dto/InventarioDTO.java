package com.gestionmaquinitas.GestionMaquinas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class InventarioDTO {
    private Long id;

    private String nombre;
    private Integer stock;
}
