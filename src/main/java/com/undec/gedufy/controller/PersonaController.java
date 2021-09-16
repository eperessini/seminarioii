package com.undec.gedufy.controller;

import com.undec.gedufy.dto.PersonaDTO;
import com.undec.gedufy.dto.Response;
import com.undec.gedufy.service.PersonaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author etorrielli
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/personas")
@Tag(name = "Personas", description = "Toda la info de Personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public ResponseEntity<Response> list() {
        Response response = personaService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable String id) {
        Response response = personaService.findOneById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> put(@RequestBody PersonaDTO input) throws Exception {
        Response response = personaService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody PersonaDTO input) throws Exception {
        Response response = personaService.save(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Response response = personaService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Response> list(@PathVariable String nombre) {
        Response response = personaService.findByName(nombre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}