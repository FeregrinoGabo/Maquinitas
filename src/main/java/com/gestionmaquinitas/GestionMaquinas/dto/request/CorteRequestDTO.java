package com.gestionmaquinitas.GestionMaquinas.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorteRequestDTO {
    @NotNull(message = "No posible dejar vacio el campo de dinero recolectado")
    private BigDecimal dineroRecolectado;
    @NotNull(message = "No posible dejar vacio la cantidad de peluches restantes")
    private Integer peluchesRestantes;
    @NotNull(message = "No posible dejar vacio el porcentaje correspondiente a la tienda")
    private Integer porcentajePactado;
    @NotNull(message = "No posible dejar vacio la cantidad de peluches puestos")
    private Integer recargaPeluches;
    @NotNull(message = "No posible dejar vacio el campo usuario")
    private Long idUsuario;
    @NotNull(message = "No posible dejar vacio el campos asignacion")
    private Long idAsignacion;

}
