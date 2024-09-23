package com.ejercicioeldar.api.controller;

import com.ejercicioeldar.api.model.Persona;
import com.ejercicioeldar.api.service.PersonaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personaService.registrarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPersona);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Optional<Persona>> obtenerPersona(@PathVariable String dni) {
        Optional<Persona> persona = personaService.buscarPersonaPorDni(dni);
        if (persona != null) {
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Persona>> listarPersonas() {
        List<Persona> personas = personaService.listarPersonas();
        return ResponseEntity.ok(personas);
    }
}
