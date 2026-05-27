package com.gestionmaquinitas.GestionMaquinas.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Corte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal dineroRecolectado;
    @CreationTimestamp
    private LocalDateTime fechaCorte;
    private Integer peluchesRestantes;
    private Integer porcentajePactado;

    private BigDecimal costoPorPeluche;
    private Integer recargaPeluches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignacion_id")
    @ToString.Exclude
    private Asignacion asignacion;
}
