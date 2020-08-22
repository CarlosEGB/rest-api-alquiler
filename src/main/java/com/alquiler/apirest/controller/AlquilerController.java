package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Alquiler;
import com.alquiler.apirest.service.AlquillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlquilerController {

    @Autowired
    private AlquillerService alquilerService;

    @PostMapping("/alquiler")
    public Alquiler postAlquiler(@RequestBody Alquiler alquiler) {
        return alquilerService.postAlquiler(alquiler);
    }
}