package com.salesianostriana.dam.ejerciciobibliotecas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
