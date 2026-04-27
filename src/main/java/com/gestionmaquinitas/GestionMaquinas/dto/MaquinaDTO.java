package com.gestionmaquinitas.GestionMaquinas.dto;

import com.gestionmaquinitas.GestionMaquinas.model.EstadoMaquina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class MaquinaDTO {
    private Long id;
    private String color;
    private Integer capacidad;
    private String descripcion;

    private EstadoMaquina estado;
}
