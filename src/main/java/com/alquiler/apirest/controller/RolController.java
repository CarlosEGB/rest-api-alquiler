package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Rol;
import com.alquiler.apirest.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/rol")
    public Rol postRol(@RequestBody Rol rol) {
        return rolService.postRol(rol);
    }
}
