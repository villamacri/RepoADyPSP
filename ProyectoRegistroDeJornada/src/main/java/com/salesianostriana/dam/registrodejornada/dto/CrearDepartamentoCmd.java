package com.salesianostriana.dam.registrodejornada.dto;

import com.salesianostriana.dam.registrodejornada.model.Departamento;

public record CrearDepartamentoCmd(
        String nombre,
        double presupuesto
) {

    public Departamento toEntity(){
        return Departamento.builder()
                .nombre(this.nombre)
                .presupuesto(this.presupuesto)
                .build();
    }
}
