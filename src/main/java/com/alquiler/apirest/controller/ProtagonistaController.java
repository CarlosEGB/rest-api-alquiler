package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Protagonista;
import com.alquiler.apirest.service.ProtagonistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProtagonistaController {

    @Autowired
    private ProtagonistaService protagonistaService;

    @PostMapping("/protagonista")
    private Protagonista postProtagonista(@RequestBody Protagonista protagonista) {
        return protagonistaService.postProtagonista(protagonista);
    }

    @GetMapping("/protagonista")
    private List<Protagonista> getAllProtagonistas() {
        return protagonistaService.getAllProtagonistas();
    }

    @GetMapping("/protagonista/{id}")
    private Protagonista getProtagonista(@PathVariable(name = "id") int idProtagonista) {
        return protagonistaService.getProtagonistas(idProtagonista);
    }

    @DeleteMapping("/protagonista/{id}")
    public ResponseEntity<Integer> deleteProtagonista(@PathVariable(name = "id") int idProtagonista) {
        if (protagonistaService.deleteProtagonista(idProtagonista)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idProtagonista, HttpStatus.OK);
    }
}
