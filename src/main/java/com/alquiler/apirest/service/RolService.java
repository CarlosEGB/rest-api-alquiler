package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Rol;
import com.alquiler.apirest.repository.IRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private IRol rolRepo;

    public Rol postRol(Rol rol) {
        return rolRepo.save(rol);
    }
}
