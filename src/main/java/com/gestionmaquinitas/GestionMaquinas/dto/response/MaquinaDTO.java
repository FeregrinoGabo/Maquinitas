package com.gestionmaquinitas.GestionMaquinas.dto.response;

import com.gestionmaquinitas.GestionMaquinas.model.EstadoMaquina;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaquinaDTO {
    private Long id;
    private String color;
    private Integer capacidad;
    private String descripcion;

    private EstadoMaquina estado;
}
