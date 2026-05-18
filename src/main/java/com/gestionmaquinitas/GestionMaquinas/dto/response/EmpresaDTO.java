package com.gestionmaquinitas.GestionMaquinas.dto.response;

import lombok.*;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaDTO {
    private Long id;

    private String nombre;
}
