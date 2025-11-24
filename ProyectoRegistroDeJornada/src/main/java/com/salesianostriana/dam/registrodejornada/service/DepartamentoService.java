package com.salesianostriana.dam.registrodejornada.service;

import com.salesianostriana.dam.registrodejornada.dto.CrearDepartamentoCmd;
import com.salesianostriana.dam.registrodejornada.error.DepartamentoNotFoundException;
import com.salesianostriana.dam.registrodejornada.model.Departamento;
import com.salesianostriana.dam.registrodejornada.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public List<Departamento>getAll(){
        List<Departamento> result = departamentoRepository.findAll();

        if(result.isEmpty()){
            throw new DepartamentoNotFoundException("No hay departamentos registrados");
        }
        return result;
    }

    public Departamento getById(Long id){
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoNotFoundException(id));
    }

    public Departamento save(CrearDepartamentoCmd cmd){
        if (!StringUtils.hasText(cmd.nombre())){
            throw new IllegalArgumentException("Error al crear un departamento");
        }
        return departamentoRepository.save(cmd.toEntity());
    }

    public Departamento edit(CrearDepartamentoCmd cmd, Long id){
        return departamentoRepository.findById(id)
                .map(departamento -> {
                    departamento.setNombre(cmd.nombre());
                    departamento.setPresupuesto(cmd.presupuesto());

                    return departamentoRepository.save(departamento);
                })
                .orElseThrow(() -> new RuntimeException());
    }

    public void delete(Departamento departamento){
       deleteById(departamento.getId());
    }

    public void deleteById(Long id){
        departamentoRepository.deleteById(id);
    }

}
