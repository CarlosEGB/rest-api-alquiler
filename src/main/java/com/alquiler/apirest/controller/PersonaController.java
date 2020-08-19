package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Persona;
import com.alquiler.apirest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/persona")
    public Persona postPersona(@RequestBody Persona persona){
        return personaService.postService(persona);
    }
}