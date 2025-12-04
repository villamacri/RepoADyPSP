package com.salesianostriana.dam.ejerciciobibliotecas;


import com.salesianostriana.dam.ejerciciobibliotecas.modelo.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
