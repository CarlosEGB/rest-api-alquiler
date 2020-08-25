package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Plataforma;
import com.alquiler.apirest.service.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @PostMapping("/plataforma")
    public Plataforma postPlataforma(@RequestBody Plataforma plataforma) {
        return plataformaService.postPlataforma(plataforma);
    }
}