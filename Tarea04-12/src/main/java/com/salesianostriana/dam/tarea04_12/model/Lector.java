package com.salesianostriana.dam.tarea04_12.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lector {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String dni;

    @OneToMany(mappedBy = "lector", fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private List<Libro> libros=new ArrayList<>();
}
