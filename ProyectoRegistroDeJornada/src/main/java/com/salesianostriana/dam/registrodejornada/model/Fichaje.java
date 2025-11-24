package com.salesianostriana.dam.registrodejornada.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Fichaje {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime momento;

    @Enumerated(EnumType.STRING)
    private TipoFichaje tipo;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_fichaje_empleado"))
    private Empleado empleado;
}
