package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Persona;
import com.alquiler.apirest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Integer> deletePersona(@PathVariable(name = "id") int idPersona) {
        if (personaService.deletePersona(idPersona)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idPersona, HttpStatus.OK);
    }
}