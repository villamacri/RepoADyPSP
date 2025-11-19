package com.salesianostriana.dam.ejerciciobibliotecas.controller;

import com.salesianostriana.dam.ejerciciobibliotecas.modelo.Biblioteca;
import com.salesianostriana.dam.ejerciciobibliotecas.servicio.BibliotecaResponse;
import com.salesianostriana.dam.ejerciciobibliotecas.servicio.BibliotecaServicio;
import com.salesianostriana.dam.ejerciciobibliotecas.servicio.CreaBibliotecaCmd;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Bibliotecas", description = "Operaciones relacionadas con bibliotecas")
@RestController
@RequestMapping("/biblioteca")
@RequiredArgsConstructor
public class BibliotecaController {

    private final BibliotecaServicio servicio;

    @GetMapping
    @Operation(summary = "Obtiene todas las bibliotecas filtradas o no")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado bibliotecas",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = BibliotecaResponse.class)),
                            examples = @ExampleObject(
                                    value = """
                                            [{"id":1, "nombreCiudad":"Sevilla", "nombreBiblioteca":"Biblioteca Municipal", "anioFundacion":"1930", "cantLibrosArox":2500, "descripcion":"Esta to guapa", "urlBiblioteca":"http://bibliotecamunicipal.es"}]
                                            """
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado ninguna biblioteca")
    })
    public List<BibliotecaResponse> getAll() {
        return servicio.getAll()
                .stream()
                .map(biblioteca -> BibliotecaResponse.of(biblioteca))
                .toList();
    }

    @GetMapping("/{id}")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "Producto encontrado",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = CreaBibliotecaCmd.class),
                        examples = @ExampleObject(
                                value = """
                                            [{"id":1, "nombreCiudad":"Sevilla", "nombreBiblioteca":"Biblioteca Municipal", "anioFundacion":"1930", "cantLibrosArox":2500, "descripcion":"Esta to guapa", "urlBiblioteca":"http://bibliotecamunicipal.es"}]
                                            """
                        )
                )
        ),
        @ApiResponse(responseCode = "404", description = "No se ha encontrado ninguna biblioteca con ese id")
    })
    public ResponseEntity<BibliotecaResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(
                BibliotecaResponse.of(servicio.getById(id)));
    }

    @PostMapping
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Biblioteca creada correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CreaBibliotecaCmd.class),
                            examples = @ExampleObject(
                                    value = """
                                            [{"id":1, "nombreCiudad":"Sevilla", "nombreBiblioteca":"Biblioteca Municipal", "anioFundacion":"1930", "cantLibrosArox":2500, "descripcion":"Esta to guapa", "urlBiblioteca":"http://bibliotecamunicipal.es"}]
                                            """
                            )
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Error al crear biblioteca, validación o campos incorrectos"),
    })
    public ResponseEntity<BibliotecaResponse> create(
            @RequestBody CreaBibliotecaCmd cmd
    ){
        Biblioteca nueva = servicio.save(cmd);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BibliotecaResponse.of(nueva));
    }

    @PutMapping("/{id}")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Biblioteca actualizada",
                    content = @Content(
                            schema = @Schema(implementation = CreaBibliotecaCmd.class),
                            examples = @ExampleObject(
                                    value = """
                                            [{"id":1, "nombreCiudad":"Sevilla", "nombreBiblioteca":"Biblioteca Municipal", "anioFundacion":"1930", "cantLibrosArox":2500, "descripcion":"Esta to guapa", "urlBiblioteca":"http://bibliotecamunicipal.es"}]
                                            """
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Error, la biblioteca no existe"),
            @ApiResponse(responseCode = "40", description = "Error, datos incorrectos")
    })
    public ResponseEntity<BibliotecaResponse> edit(
            @PathVariable Long id,
            @RequestBody CreaBibliotecaCmd cmd){
        return ResponseEntity.ok(
                BibliotecaResponse.of(
                        servicio.edit(cmd, id)
                )
        );
    }

    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Eliminado correctamente"
            ),
            @ApiResponse(responseCode = "404", description = "Error, la biblioteca no existe")
    })
    public ResponseEntity<?>delete(@PathVariable Long id){
        servicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
