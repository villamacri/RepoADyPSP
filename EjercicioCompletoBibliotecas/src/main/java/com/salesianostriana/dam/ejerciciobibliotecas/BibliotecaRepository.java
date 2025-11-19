package com.salesianostriana.dam.ejerciciobibliotecas;

import com.salesianostriana.dam.ejerciciobibliotecas.modelo.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
