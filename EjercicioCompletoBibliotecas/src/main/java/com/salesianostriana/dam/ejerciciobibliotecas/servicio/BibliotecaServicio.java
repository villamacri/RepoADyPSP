package com.salesianostriana.dam.ejerciciobibliotecas.servicio;

import com.salesianostriana.dam.ejerciciobibliotecas.BibliotecaRepository;
import com.salesianostriana.dam.ejerciciobibliotecas.dto.CreaBibliotecaCmd;
import com.salesianostriana.dam.ejerciciobibliotecas.error.LibraryNotFoundException;
import com.salesianostriana.dam.ejerciciobibliotecas.modelo.Biblioteca;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaServicio {
    private final BibliotecaRepository repository;

    public List<Biblioteca> getAll(){
        List<Biblioteca> result = repository.findAll();
        if (result.isEmpty())
            throw new LibraryNotFoundException("No hay bibliotecas registradas");

        return result;
    }

    public Biblioteca getById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException(id));
    }

    public Biblioteca save(CreaBibliotecaCmd cmd){
        if(!StringUtils.hasText(cmd.nombreBiblioteca())){
            throw new IllegalArgumentException("Error al crear biblioteca");
        }

        return repository.save(cmd.toEntity());
    }

    public Biblioteca edit(CreaBibliotecaCmd cmd, Long id){
        return repository.findById(id)
                .map(biblioteca -> {
                    biblioteca.setNombreCiudad(cmd.nombreCiudad());
                    biblioteca.setNombreBiblioteca(cmd.nombreBiblioteca());
                    biblioteca.setAnioFundacion(cmd.anioFundacion());
                    biblioteca.setCantAproxLibros(cmd.cantAproxLibros());
                    biblioteca.setDescripcion(cmd.descripcion());
                    biblioteca.setUrlBiblioteca(cmd.urlBiblioteca());

                    return repository.save(biblioteca);
                })
                .orElseThrow(() -> new RuntimeException());
    }

    public void deleteById(Long id){repository.deleteById(id);}

    public void delete(Biblioteca biblioteca){deleteById(biblioteca.getId());}
}
