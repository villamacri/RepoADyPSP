package com.salesianostriana.dam.tareamonumentodto;

import com.salesianostriana.dam.tareamonumentodto.modelo.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}
