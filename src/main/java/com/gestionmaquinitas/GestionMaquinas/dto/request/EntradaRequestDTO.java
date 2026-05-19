package com.gestionmaquinitas.GestionMaquinas.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EntradaRequestDTO {
    @NotNull(message = "El campo cantidad debe tener algun valor")
    private Integer cantidad;
    @NotNull(message = "El campo de costo no puede quedar vacio")
    private BigDecimal costo;
    @Size(max = 256, message = "El mensaje es muy largo. Tamaño maximo: 256 caracteres")
    private String descripcion;
    //Este campo se puede tener automaticamente de la sesion del usuario que efectue la operacion?
    private Long idEncargado;
}
