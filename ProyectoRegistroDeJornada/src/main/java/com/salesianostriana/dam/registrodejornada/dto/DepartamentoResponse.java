package com.salesianostriana.dam.registrodejornada.dto;

import com.salesianostriana.dam.registrodejornada.model.Departamento;

public record DepartamentoResponse(
        Long id,
        String nombre,
        double presupuesto
) {

    public static DepartamentoResponse of(Departamento departamento){
        return new DepartamentoResponse(
                departamento.getId(),
                departamento.getNombre(),
                departamento.getPresupuesto()
        );
    }
}

