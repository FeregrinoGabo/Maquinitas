package com.gestionmaquinitas.GestionMaquinas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;
    private String estado;
    private String municipio;
    private String colonia;
    private Integer porcentajeBase;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaRetiro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    @ToString.Exclude
    private Empresa empresa;

    @OneToMany (mappedBy = "tienda", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = false)
    private List<Asignacion> asignaciones;
}
