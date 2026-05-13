package com.gestionmaquinitas.GestionMaquinas.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private Long id;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    private String username;
}
