package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Desarrolladora;
import com.alquiler.apirest.repository.IDesarrolladora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesarrolladoraService {

    @Autowired
    private IDesarrolladora desarrolladoraRepo;

    public Desarrolladora postDesarrolladora(Desarrolladora desarrolladora) {
        return desarrolladoraRepo.save(desarrolladora);
    }

    public Desarrolladora getDesarrolladora(int idDesarrolladora) {
        return desarrolladoraRepo.findById(idDesarrolladora).get();
    }

    public List<Desarrolladora> getAllDesarrolladoras() {
        return desarrolladoraRepo.findAll();
    }
}
