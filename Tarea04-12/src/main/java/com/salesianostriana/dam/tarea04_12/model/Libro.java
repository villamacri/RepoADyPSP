package com.salesianostriana.dam.tarea04_12.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String isbn;
    private String autor;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_lector_libro"))
    private Lector lector;
}
