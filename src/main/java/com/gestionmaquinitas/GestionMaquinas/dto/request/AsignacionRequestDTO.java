package com.gestionmaquinitas.GestionMaquinas.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsignacionRequestDTO {

    @NotNull(message = "No posible dejar vacia la fecha de asignacion")
    private LocalDateTime fechaAsignacion;
    @NotNull(message = "No posible dejar vacio el Usuario")
    private Long idUsuario;
    @NotNull(message = "No posible dejar vacia la Tienda")
    private Long idTienda;
    @NotNull(message = "No posible dejar vacia la Maquina")
    private Long idMaquina;
}
