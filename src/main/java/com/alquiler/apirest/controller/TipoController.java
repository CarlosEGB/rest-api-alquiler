package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Tipo;
import com.alquiler.apirest.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping("/tipo")
    public Tipo postTipo(@RequestBody Tipo tipo) {
        return tipoService.postTipo(tipo);
    }
}