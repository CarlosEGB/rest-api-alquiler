package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Protagonista;
import com.alquiler.apirest.repository.IProtagonista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtagonistaService {

    @Autowired
    private IProtagonista protagonistaRepo;

    public Protagonista postProtagonista(Protagonista protagonista) {
        return protagonistaRepo.save(protagonista);
    }
}
