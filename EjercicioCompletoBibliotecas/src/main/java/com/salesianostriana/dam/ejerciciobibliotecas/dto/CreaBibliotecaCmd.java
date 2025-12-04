package com.salesianostriana.dam.ejerciciobibliotecas.dto;

import com.salesianostriana.dam.ejerciciobibliotecas.modelo.Biblioteca;

public record CreaBibliotecaCmd(
        String nombreCiudad,
        String nombreBiblioteca,
        String anioFundacion,
        int cantAproxLibros,
        String descripcion,
        String urlBiblioteca
) {

    public Biblioteca toEntity(){
        return Biblioteca.builder()
                .nombreCiudad(this.nombreCiudad())
                .nombreBiblioteca(this.nombreBiblioteca())
                .anioFundacion(this.anioFundacion())
                .cantAproxLibros(this.cantAproxLibros)
                .descripcion(this.descripcion())
                .urlBiblioteca(this.urlBiblioteca())
                .build();
    }
}
