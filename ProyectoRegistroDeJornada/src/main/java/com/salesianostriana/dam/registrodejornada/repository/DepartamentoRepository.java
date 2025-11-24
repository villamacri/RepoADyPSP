package com.salesianostriana.dam.registrodejornada.repository;

import com.salesianostriana.dam.registrodejornada.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
