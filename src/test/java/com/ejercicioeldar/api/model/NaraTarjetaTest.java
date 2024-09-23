package com.ejercicioeldar.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NaraTarjetaTest {

    private Tarjeta tarjeta;

    @BeforeEach
    public void crearTarjeta(){
        tarjeta = new Tarjeta("1234567890123456", LocalDate.of(2025, 12, 31), "456", "NARA");
    }
    
    @Test
    public void testCalcularTasaDia20() {
        double resultado = tarjeta.calcularTasa(LocalDate.of(2024, 9, 20));
        double resultadoEsperado = 10;

        assertEquals(resultado,resultadoEsperado);
    }

    @Test
    public void testCalcularTasaDia10() {
        double resultado = tarjeta.calcularTasa(LocalDate.of(2024, 9, 10));
        double resultadoEsperado = 5;
        
        assertEquals(resultado,resultadoEsperado);
    }
}
