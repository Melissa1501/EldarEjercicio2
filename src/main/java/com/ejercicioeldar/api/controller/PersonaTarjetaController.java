package com.ejercicioeldar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ejercicioeldar.api.model.Tarjeta;
import com.ejercicioeldar.api.service.TarjetaService;

@RestController
@RequestMapping("/api/personas/{dni}/tarjetas")
public class PersonaTarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @PostMapping
    public ResponseEntity<Tarjeta> crearTarjeta(@PathVariable String dni, @RequestBody Tarjeta tarjeta) {
        Tarjeta nuevaTarjeta = tarjetaService.registrarTarjeta(dni, tarjeta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarjeta);
    }

    @GetMapping
    public ResponseEntity<List<Tarjeta>> listarTarjetas(@PathVariable String dni) {
        List<Tarjeta> tarjetas = tarjetaService.buscarTarjetasPorDni(dni);
        return ResponseEntity.ok(tarjetas);
    }
}

