package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Juego;
import com.alquiler.apirest.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JuegoController {

    @Autowired
    private JuegoService servicioJuego;

    @PostMapping("/juego")
    public Juego postJuego(@RequestBody Juego bodyJuego) {
        return servicioJuego.guardarJuego(bodyJuego);
    }

    @GetMapping("/juego")
    public List<Juego> getAllJuegos() {
        return servicioJuego.getJuegos();
    }
}
