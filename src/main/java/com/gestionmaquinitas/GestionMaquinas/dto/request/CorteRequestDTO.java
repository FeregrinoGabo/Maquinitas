package com.gestionmaquinitas.GestionMaquinas.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorteRequestDTO {
    @NotNull(message = "No posible dejar vacio el campo de dinero recolectado")
    private BigDecimal dineroRecolectado;
    private LocalDateTime fechaCorte; //No se como poner este dato, porque contiene mucha infomacion como para que sea puesta de manera manual, pero los cortes no siempre se hacen de manera inmediata, entonces necesita ser algo que se pueda colocar inclusive dias despues del corte
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
