package com.ejercicioeldar.api.responses;

public class TasaResponse {
    private String marca;
    private double importe;

    public TasaResponse(String marca, double importe) {
        this.marca = marca;
        this.importe = importe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
