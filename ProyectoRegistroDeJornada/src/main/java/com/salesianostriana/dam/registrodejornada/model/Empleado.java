package com.salesianostriana.dam.registrodejornada.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Empleado {
    @Id
    @GeneratedValue
    private Long id;

    private String nombreCompleto, cargo;
    private double salario;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_departamento_empleado"))
    private Departamento departamento;
}
