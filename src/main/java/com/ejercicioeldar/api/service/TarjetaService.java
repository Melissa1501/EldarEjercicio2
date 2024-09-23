package com.ejercicioeldar.api.service;

import com.ejercicioeldar.api.model.Persona;
import com.ejercicioeldar.api.model.Tarjeta;
import com.ejercicioeldar.api.repository.PersonaRepository;
import com.ejercicioeldar.api.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private JavaMailSender mailSender;

    // Registrar una nueva tarjeta
    public Tarjeta registrarTarjeta(String dni, Tarjeta tarjeta) {
        Persona persona = personaRepository.findByDni(dni)
                            .orElseThrow(() -> new IllegalArgumentException("Persona no encontrada con DNI: " + dni));

        // Asociar la tarjeta a la persona
        tarjeta.setPersona(persona);

        // Enviar datos sensibles al email de la persona
        enviarDatosAEmail(persona.getEmail(), tarjeta);

        return tarjetaRepository.save(tarjeta);
    }

    public void enviarDatosAEmail(String email, Tarjeta tarjeta) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Datos de su Tarjeta");
        message.setText("Nro de Tarjeta: " + tarjeta.getNumero() + "\n" +
                        "CVV: " + tarjeta.getCvv());
        mailSender.send(message);
    }

    // Buscar todas las tarjetas de una persona por su DNI
    public List<Tarjeta> buscarTarjetasPorDni(String dni) {
        Persona persona = personaRepository.findByDni(dni)
                            .orElseThrow(() -> new IllegalArgumentException("Persona no encontrada con DNI: " + dni));

        return persona.getTarjetas();
    }

    // Buscar tarjeta por su marca
    public Tarjeta buscarTarjetaPorMarca(String marca) {
        return tarjetaRepository.findByMarca(marca);
    }

    // Calcular la tasa según la tarjeta
    public double calcularTasa(Tarjeta tarjeta, LocalDate fecha) {
        return tarjeta.calcularTasa(fecha);
    }

    // Consultar si una tarjeta es válida para operar
    public boolean esValidaParaOperacion(Tarjeta tarjeta, double monto, String cvv) {
        return tarjeta.esValidaParaOperacion();
    }

    public List<Tarjeta> listarTarjetas() {
        return tarjetaRepository.findAll();
    }
}
