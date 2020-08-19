package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Persona;
import com.alquiler.apirest.repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private IPersona personaRepo;

    public Persona postService(Persona persona) {
        return personaRepo.save(persona);
    }

    public List<Persona> getAllPersonas() {
        return personaRepo.findAll();
    }

    public Persona getPersona(int idPersona) {
        return personaRepo.findById(idPersona).get();
    }

    public boolean deletePersona(int idPersona) {
        personaRepo.deleteById(idPersona);
        return personaRepo.existsById(idPersona);
    }
}