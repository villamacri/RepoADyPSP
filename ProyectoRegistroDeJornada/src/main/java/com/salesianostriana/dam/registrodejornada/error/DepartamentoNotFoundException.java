package com.salesianostriana.dam.registrodejornada.error;

public class DepartamentoNotFoundException extends RuntimeException {
    public DepartamentoNotFoundException(String message) {
        super(message);
    }

    public DepartamentoNotFoundException(){
        super("Departamento no encontrado");
    }

    public DepartamentoNotFoundException(Long id){
        super("No se ha encontrado el departamento con id %d".formatted(id));
    }

}
