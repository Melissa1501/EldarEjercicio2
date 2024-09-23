package com.ejercicioeldar.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AmexTarjetaTest {

    private Tarjeta tarjeta;

    @BeforeEach
    public void crearTarjeta(){
        tarjeta = new Tarjeta("1234567890123456", LocalDate.of(2025, 12, 31), "789", "AMEX");
    }
    
    @Test
    public void testCalcularTasaOctubre() {
        double resultado = tarjeta.calcularTasa(LocalDate.of(2024, 10, 20));
        double resultadoEsperado = 1;
        
        assertEquals(resultado,resultadoEsperado);
    }
    
    @Test
    public void testCalcularTasaEnero() {
        double resultado = tarjeta.calcularTasa(LocalDate.of(2024, 1, 20));
        double resultadoEsperado = 0.1;
        
        assertEquals(resultado,resultadoEsperado);
    }
}
