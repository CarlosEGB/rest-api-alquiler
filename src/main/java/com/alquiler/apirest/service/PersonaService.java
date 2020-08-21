package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Persona;
import com.alquiler.apirest.entity.Rol;
import com.alquiler.apirest.repository.IPersona;
import com.alquiler.apirest.repository.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private IPersona personaRepo;

    @Autowired
    private IRol rolRepo;

    public Persona postService(Persona persona) {
        Persona savePersona = new Persona();
        savePersona.setDni(persona.getDni());
        savePersona.setNombre(persona.getNombre());
        savePersona.setNacimiento(persona.getNacimiento());
        savePersona.setTelefono(persona.getTelefono());

        Rol rol = rolRepo.findById(persona.getRol().getIdRol()).get();
        savePersona.setRol(rol);

        return personaRepo.save(savePersona);
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

    public Persona putPersona(Persona persona) {
        return personaRepo.save(persona);
    }
}