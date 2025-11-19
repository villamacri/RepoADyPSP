package com.salesianostriana.dam.ejerciciobibliotecas.servicio;

import com.salesianostriana.dam.ejerciciobibliotecas.modelo.Biblioteca;

public record BibliotecaResponse(
        Long id,
        String nombreCiudad,
        String nombreBiblioteca,
        String anioFundacion,
        int cantAproxLibros,
        String descripcion,
        String urlBiblioteca

) {

    public static BibliotecaResponse of(Biblioteca biblioteca){
        return new BibliotecaResponse(
                biblioteca.getId(),
                biblioteca.getNombreCiudad(),
                biblioteca.getNombreBiblioteca(),
                biblioteca.getAnioFundacion(),
                biblioteca.getCantAproxLibros(),
                biblioteca.getDescripcion(),
                biblioteca.getUrlBiblioteca()
        );
    }
}
