package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Desarrolladora;
import com.alquiler.apirest.service.DesarrolladoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DesarrolladoraController {

    @Autowired
    private DesarrolladoraService desarrolladoraService;

    @PostMapping("/desarrolladora")
    public Desarrolladora saveDesarrolladora(@RequestBody Desarrolladora desarrolladora) {
        return desarrolladoraService.postDesarrolladora(desarrolladora);
    }

    @GetMapping("/desarrolladora/{id}")
    public Desarrolladora getDesarrolladora(@PathVariable(name = "id") int idDesarrolladora) {
        return desarrolladoraService.getDesarrolladora(idDesarrolladora);
    }

    @GetMapping("/desarrolladora")
    public List<Desarrolladora> getAllDesarrolladoras() {
        return desarrolladoraService.getAllDesarrolladoras();
    }
}
