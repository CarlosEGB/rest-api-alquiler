package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Tipo;
import com.alquiler.apirest.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping("/tipo")
    public Tipo postTipo(@RequestBody Tipo tipo) {
        return tipoService.postTipo(tipo);
    }

    @GetMapping("/tipo")
    public List<Tipo> getAllTipo() {
        return tipoService.getAllTipo();
    }

    @GetMapping("/tipo/{id}")
    public Tipo getTipo(@PathVariable(name = "id") int idTipo) {
        return tipoService.getTipo(idTipo);
    }

    @DeleteMapping("/tipo/{id}")
    public ResponseEntity<Integer> deleteTipo(@PathVariable(name = "id") int idTipo) {
        if (tipoService.deleteTipo(idTipo)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idTipo, HttpStatus.OK);
    }

    @PutMapping("/tipo")
    public Tipo putTipo(@RequestBody Tipo tipo) {
        return tipoService.putTipo(tipo);
    }
}