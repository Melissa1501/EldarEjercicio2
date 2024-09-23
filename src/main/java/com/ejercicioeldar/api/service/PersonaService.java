package com.ejercicioeldar.api.service;

import com.ejercicioeldar.api.model.Persona;
import com.ejercicioeldar.api.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    // Crear una nueva persona
    public Persona registrarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    // Buscar una persona por DNI
    public Optional<Persona> buscarPersonaPorDni(String dni) {
        return personaRepository.findByDni(dni);
    }

    // Listar todas las personas
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    // Modificar una persona existente
    public Persona actualizarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    // Eliminar una persona
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
