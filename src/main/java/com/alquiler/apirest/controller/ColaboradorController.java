package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Colaborador;
import com.alquiler.apirest.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping("/colaborador")
    public Colaborador postColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.postColaborador(colaborador);
    }
}
