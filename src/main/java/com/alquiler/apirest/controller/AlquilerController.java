package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Alquiler;
import com.alquiler.apirest.service.AlquillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlquilerController {

    @Autowired
    private AlquillerService alquilerService;

    @PostMapping("/alquiler")
    public Alquiler postAlquiler(@RequestBody Alquiler alquiler) {
        return alquilerService.postAlquiler(alquiler);
    }

    @GetMapping("/alquiler")
    public List<Alquiler> getAllAlquiler() {
        return alquilerService.getAllAlquiler();
    }

    @GetMapping("/alquiler/{id}")
    public Alquiler getAlquiler(@PathVariable(name = "id") int idAlquiler) {
        return alquilerService.getAlquiler(idAlquiler);
    }
}