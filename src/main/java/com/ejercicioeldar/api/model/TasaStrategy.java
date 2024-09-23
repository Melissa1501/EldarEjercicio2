package com.ejercicioeldar.api.model;

import java.time.LocalDate;

public interface TasaStrategy {
    double calcularTasa(LocalDate fecha);
}
