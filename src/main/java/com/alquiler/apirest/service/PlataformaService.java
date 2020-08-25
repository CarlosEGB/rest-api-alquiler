package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Plataforma;
import com.alquiler.apirest.repository.IPlataforma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaService {

    @Autowired
    private IPlataforma plataformaRepo;

    public Plataforma postPlataforma(Plataforma plataforma) {
        return plataformaRepo.save(plataforma);
    }

    public List<Plataforma> getAllPlataforma() {
        return plataformaRepo.findAll();
    }

    public Plataforma getPlataforma(int idPlataforma) {
        return plataformaRepo.findById(idPlataforma).get();
    }

    public boolean deletePlataforma(int idPlataforma) {
        plataformaRepo.deleteById(idPlataforma);
        return plataformaRepo.existsById(idPlataforma);
    }
}