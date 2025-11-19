package com.salesianostriana.dam.ejerciciobibliotecas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LibraryNotFoundException.class)
    public ProblemDetail handleBibliotecaNotFound(
            LibraryNotFoundException exception
    ){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, exception.getMessage()
        );

        problemDetail.setTitle("Biblioteca no encontrada");
        problemDetail.setType(
                URI.create("http://dam.salesianos-triana.com/biblioteca-not-found")
        );
        return problemDetail;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleBadLibrary(IllegalArgumentException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                exception.getMessage());
        return problemDetail;
    }
}
