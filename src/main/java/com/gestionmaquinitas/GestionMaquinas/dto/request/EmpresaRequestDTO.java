package com.gestionmaquinitas.GestionMaquinas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmpresaRequestDTO {
    @NotBlank(message = "La empresa debe tener un nombre")
    @Size(min = 3, max = 128, message = "El nombre de la empresa debe tener entre 3 y 128 caracteres")
    private String nombre;

}
