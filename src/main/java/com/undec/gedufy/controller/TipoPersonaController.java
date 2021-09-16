package com.undec.gedufy.controller;

import com.undec.gedufy.dto.Response;
import com.undec.gedufy.model.TipoPersona;
import com.undec.gedufy.service.TipoPersonaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author etorrielli
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipos-persona")
@Tag(name = "TiposPersona", description = "Toda la info de TiposPersona")
public class TipoPersonaController {

    @Autowired
    private TipoPersonaService tipoPersonaService;

    @GetMapping()
    public ResponseEntity<Response> list() {
        Response response = tipoPersonaService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable String id) {
        Response response = tipoPersonaService.findOneById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Response> put(@RequestBody Object input) {
        Response response = tipoPersonaService.update(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> post(@RequestBody TipoPersona input) {
        Response response = tipoPersonaService.save(input);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        Response response = tipoPersonaService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}