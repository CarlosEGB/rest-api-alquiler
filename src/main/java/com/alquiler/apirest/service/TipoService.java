package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Tipo;
import com.alquiler.apirest.repository.ITipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoService {

    @Autowired
    private ITipo tipoRepo;

    public Tipo postTipo(Tipo tipo) {
        return tipoRepo.save(tipo);
    }
}