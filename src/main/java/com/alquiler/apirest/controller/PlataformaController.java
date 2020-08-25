package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Plataforma;
import com.alquiler.apirest.service.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @PostMapping("/plataforma")
    public Plataforma postPlataforma(@RequestBody Plataforma plataforma) {
        return plataformaService.postPlataforma(plataforma);
    }

    @GetMapping("/plataforma")
    public List<Plataforma> getAllPlataforma() {
        return plataformaService.getAllPlataforma();
    }

    @GetMapping("/plataforma/{id}")
    public Plataforma getPlataforma(@PathVariable(name = "id") int idPlataforma) {
        return plataformaService.getPlataforma(idPlataforma);
    }

    @DeleteMapping("/plataforma/{id}")
    public ResponseEntity<Integer> deletePlataforma(@PathVariable(name = "id") int idPlataforma) {
        if (plataformaService.deletePlataforma(idPlataforma)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idPlataforma, HttpStatus.OK);
    }
}