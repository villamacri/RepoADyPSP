package com.salesianostriana.dam.tareamonumentodto.controller;

import com.salesianostriana.dam.tareamonumentodto.modelo.Monumento;
import com.salesianostriana.dam.tareamonumentodto.servicio.CrearMonumentoCmd;
import com.salesianostriana.dam.tareamonumentodto.servicio.MonumentoResponse;
import com.salesianostriana.dam.tareamonumentodto.servicio.MonumentoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
public class MonumentoController {

    private final MonumentoServicio servicio;

    @GetMapping
    @Operation(summary = "Obtiene todos los monumentos filtrados o no")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se han encontrado monumentos",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MonumentoResponse.class)),
                            examples = @ExampleObject(
                                    value = """
                                            [{ "id":1,"isoCode":"1234", "pais":"España", "localizacion":"0,0", "nombre":"Giralda"}]
                                            """
                                    //Lo óptimo es poner todos los atributos del DTO en los valores con los ExampleObject
                            )
                    )
            ),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado ningún monumento")
    })

    public List<MonumentoResponse> getAll(){
        return servicio.getAll()
                .stream()
                .map(monumento -> MonumentoResponse.of(monumento))
                //.map(MonumentoResponse::of)
                .toList();
    }

    @ApiResponse(
            responseCode = "200",
            description = "Producto encontrado",
            content = @Content(
                    mediaType = "application/json",
                    schema=@Schema(implementation = CrearMonumentoCmd.class)
            )
    )
    @GetMapping("/{id}")
    public ResponseEntity<MonumentoResponse> getById(@PathVariable Long id){
        /*return ResponseEntity.of(
                servicio.getById(id)
                        .map(MonumentoResponse::of)
        );*/
        return ResponseEntity.ok(
                MonumentoResponse.of(servicio.getById(id)));
    }


    @PostMapping
    public ResponseEntity<MonumentoResponse> create(
            @RequestBody CrearMonumentoCmd cmd
    ) {
        Monumento nuevo = servicio.save(cmd);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MonumentoResponse.of(nuevo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonumentoResponse> edit(
            @PathVariable Long id,
            @RequestBody CrearMonumentoCmd cmd) {

        return ResponseEntity.ok(
                MonumentoResponse.of(
                        servicio.edit(cmd, id)
                ));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        servicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}