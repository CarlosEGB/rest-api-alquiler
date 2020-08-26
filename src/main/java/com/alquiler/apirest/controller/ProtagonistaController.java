package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Protagonista;
import com.alquiler.apirest.service.ProtagonistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtagonistaController {

    @Autowired
    private ProtagonistaService protagonistaService;

    @PostMapping("/protagonista")
    private Protagonista postProtagonista(@RequestBody Protagonista protagonista) {
        return protagonistaService.postProtagonista(protagonista);
    }
}
