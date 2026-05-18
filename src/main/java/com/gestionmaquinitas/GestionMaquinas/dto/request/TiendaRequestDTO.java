package com.gestionmaquinitas.GestionMaquinas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TiendaRequestDTO {
    @NotBlank(message = "La tienda debe contener un nombre")
    private String nombre;
    @NotBlank(message = "El campo pais no debe quedar vacio")
    private String pais;
    @NotBlank(message = "El campo estado no debe quedar vacio")
    private String estado;
    @NotBlank(message = "El campo municipio no debe quedar vacio")
    private String municipio;
    @NotBlank(message = "El campo colonia no debe quedar vacio")
    private String colonia;
    @NotNull(message = "El campo porcentaje pactado no debe quedar vacio")
    private Integer porcentajeBase;
}
