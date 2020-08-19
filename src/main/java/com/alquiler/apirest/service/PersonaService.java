package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Persona;
import com.alquiler.apirest.repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private IPersona personaRepo;

    public Persona postService(Persona persona) {
     return personaRepo.save(persona);
    }
}