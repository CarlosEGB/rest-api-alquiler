package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Juego;
import com.alquiler.apirest.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/juego/{id}")
    public Juego getJuego(@PathVariable(value = "id") int idJuego) {
        return servicioJuego.getJuego(idJuego);
    }

    @GetMapping("/juego")
    public List<Juego> getAllJuegos() {
        return servicioJuego.getJuegos();
    }

    @DeleteMapping("/juego/{id}")
    public ResponseEntity<Integer> deleJuego(@PathVariable(value = "id") int idJuego) {
        if (servicioJuego.deleteJuegoById(idJuego)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idJuego, HttpStatus.OK);
    }

    @PutMapping("/juego")
    public Juego putJuego(@RequestBody Juego juego) {
        return servicioJuego.putJuego(juego);
    }
}
