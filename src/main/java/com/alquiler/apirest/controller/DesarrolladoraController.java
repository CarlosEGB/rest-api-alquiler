package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Desarrolladora;
import com.alquiler.apirest.service.DesarrolladoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DesarrolladoraController {

    @Autowired
    private DesarrolladoraService desarrolladoraService;

    @PostMapping("/desarrolladora")
    public Desarrolladora saveDesarrolladora(@RequestBody Desarrolladora desarrolladora) {
        return desarrolladoraService.postDesarrolladora(desarrolladora);
    }

}
