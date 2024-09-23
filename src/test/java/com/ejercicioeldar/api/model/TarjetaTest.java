package com.ejercicioeldar.api.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class TarjetaTest {

    @Test
    public void testTarjetaEsValida() {
        Tarjeta tarjetaVigente = new Tarjeta(
            "1234567890123456",
            LocalDate.of(2025, 12, 31), "789", "VISA"
        );

        assertTrue(tarjetaVigente.esValidaParaOperacion());
    }

    @Test
    public void testTarjetaEsInvalida() {
        Tarjeta tarjetaVencida = new Tarjeta(
            "1234567890123456",
            LocalDate.of(2023, 12, 31), "789", "VISA"
        );

        assertFalse(tarjetaVencida.esValidaParaOperacion());
    }
    
}