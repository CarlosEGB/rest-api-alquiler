package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Persona;
import com.alquiler.apirest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/persona")
    public Persona postPersona(@RequestBody Persona persona) {
        return personaService.postService(persona);
    }

    @GetMapping("/persona")
    public List<Persona> getAllPersonas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/persona/{id}")
    public Persona getPersona(@PathVariable(name = "id") int idPersona) {
        return personaService.getPersona(idPersona);
    }
}