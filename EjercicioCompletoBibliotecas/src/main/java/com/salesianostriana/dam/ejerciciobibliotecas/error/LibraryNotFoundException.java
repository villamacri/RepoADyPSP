package com.salesianostriana.dam.ejerciciobibliotecas.error;

public class LibraryNotFoundException extends RuntimeException{

    public LibraryNotFoundException(){super("Biblioteca no encontrada");}

    public LibraryNotFoundException(String message){ super(message);}

    public LibraryNotFoundException(Long id){ super("No se ha encontrado la biblioteca con id %d".formatted(id));}
}
