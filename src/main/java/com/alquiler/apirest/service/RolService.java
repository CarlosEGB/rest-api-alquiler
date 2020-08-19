package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Rol;
import com.alquiler.apirest.repository.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private IRol rolRepo;

    public Rol postRol(Rol rol) {
        return rolRepo.save(rol);
    }

    public List<Rol> getAllRoles() {
        return rolRepo.findAll();
    }

    public Rol getRol(int idRol) {
        return rolRepo.findById(idRol).get();
    }

    public boolean deleteRol(int idRol) {
        rolRepo.deleteById(idRol);
        return rolRepo.existsById(idRol);
    }

    public Rol putRol(Rol rol) {
        return rolRepo.save(rol);
    }
}
