package com.gestionmaquinitas.GestionMaquinas.dto.request;

import com.gestionmaquinitas.GestionMaquinas.model.RolUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDTO {
    @NotBlank(message = "El nombre no puede quedar vacio")
    private String nombre;
    @NotBlank(message = "El apellido paterno no puede quedar vacio")
    private String apellidoPaterno;
    @NotBlank(message = "El apellido materno no puede quedar vacio")
    private String apellidoMaterno;
    @NotBlank(message = "El username no puede quedar vacio")
    @Size(min = 3, max = 32, message = "El tamaño del username no puede ser menor de 3 y mayor a 32 caracteres")
    private String username;
    @NotBlank(message = "La contraseña no puede quedar vacio")
    @Size(min = 12, max = 128, message = "La contraseña debe tener un minimo de 12 caracteres y un maximo de 128")
    private String contrasena;
    @NotBlank(message = "El rol no puede quedar vacio")
    private RolUsuario rol;
}
