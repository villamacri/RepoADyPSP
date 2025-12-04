package com.salesianostriana.dam.ejerciciobibliotecas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Biblioteca {
    @Id
    @GeneratedValue
    private Long id;

    private String nombreCiudad;
    private String nombreBiblioteca;
    private String anioFundacion;
    private int cantAproxLibros;
    private String descripcion;
    private String urlBiblioteca;

}
