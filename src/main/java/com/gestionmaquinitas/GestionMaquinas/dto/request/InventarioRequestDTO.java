package com.gestionmaquinitas.GestionMaquinas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InventarioRequestDTO {
    @NotBlank(message = "El inventario debe tener un nombre")
    @Size(min = 3, max = 32, message = "El nombre del inventario debe tener entre 3 y 32 caracteres")
    private String nombre;
    private Integer stock;
}
