package com.salesianostriana.dam.tarea04_12.repository;

import com.salesianostriana.dam.tarea04_12.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
}
