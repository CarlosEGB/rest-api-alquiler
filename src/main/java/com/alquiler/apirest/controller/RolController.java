package com.alquiler.apirest.controller;

import com.alquiler.apirest.entity.Rol;
import com.alquiler.apirest.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping("/rol")
    public Rol postRol(@RequestBody Rol rol) {
        return rolService.postRol(rol);
    }

    @GetMapping("/rol")
    public List<Rol> getAllRoles() {
        return rolService.getAllRoles();
    }

    @GetMapping("/rol/{id}")
    public Rol getRol(@PathVariable(name = "id") int idRol) {
        return rolService.getRol(idRol);
    }

    @DeleteMapping("/rol/{id}")
    public ResponseEntity<Integer> deleteRol(@PathVariable(name = "id") int idRol) {
        if (rolService.deleteRol(idRol)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(idRol, HttpStatus.OK);
    }
}
