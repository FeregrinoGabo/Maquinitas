package com.gestionmaquinitas.GestionMaquinas.dto.request;

import com.gestionmaquinitas.GestionMaquinas.model.EstadoMaquina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MaquinaRequestDTO {

    @NotBlank(message = "El color no puede quedar en blanco")
    @Size(min = 3)
    private String color;
    @NotNull(message = "La capacidad no puede quedar vacia")
    private Integer capacidad;
    @NotNull(message = "Seleccione un estado de la maquina. Para maquinas nuevas lo recomendado es INACTIVO")
    private EstadoMaquina estado;
    @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
    private String descripcion;
}
