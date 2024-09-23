package com.ejercicioeldar.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisaTarjetaTest {

    private Tarjeta tarjeta;

    @BeforeEach
    public void crearTarjeta(){
        tarjeta = new Tarjeta("1234567890123456", LocalDate.of(2025, 12, 31), "123", "VISA");
    }

    @Test
    public void testCalcularTasaAnio2024Mes8() {
        double resultado = tarjeta.calcularTasa(LocalDate.of(2024, 8, 20));
        double resultadoEsperado = 253;
        
        assertEquals(resultado,resultadoEsperado);
    }
    
    @Test
    public void testCalcularTasaAnio2023Mes2() {
        double resultado = tarjeta.calcularTasa(LocalDate.of(2023, 2, 20));
        double resultadoEsperado = 1011.5;
        
        assertEquals(resultado,resultadoEsperado);
    }
}
