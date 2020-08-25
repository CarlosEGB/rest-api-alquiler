package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Colaborador;
import com.alquiler.apirest.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping("/colaborador")
    public Colaborador postColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.postColaborador(colaborador);
    }

    @GetMapping("/colaborador")
    public List<Colaborador> getAllColaboradores() {
        return colaboradorService.getAllColaboradores();
    }

    @GetMapping("/colaborador/{id}")
    public Colaborador getColaborador(@PathVariable(name = "id") int idColaborador) {
        return colaboradorService.getColabarador(idColaborador);
    }
}
