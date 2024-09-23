package com.ejercicioeldar.api.controller;

import com.ejercicioeldar.api.model.Tarjeta;
import com.ejercicioeldar.api.responses.TasaResponse;
import com.ejercicioeldar.api.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping("/tasa")
    public ResponseEntity<TasaResponse> consultarTasa(@RequestParam String marca, @RequestParam LocalDate fecha) {
        // Buscar la tarjeta en base a la marca (por ejemplo, este es solo un ejemplo básico)
        Tarjeta tarjeta = tarjetaService.buscarTarjetaPorMarca(marca);

        // Si no se encuentra la tarjeta, devolver un error 404
        if (tarjeta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Calcular la tasa usando la instancia de la tarjeta
        double tasa = tarjetaService.calcularTasa(tarjeta, fecha);
        TasaResponse response = new TasaResponse(tarjeta.getMarca(), tasa);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Tarjeta>> listarTarjetas() {
        List<Tarjeta> tarjetas = tarjetaService.listarTarjetas();
        return ResponseEntity.ok(tarjetas);
    }
}
