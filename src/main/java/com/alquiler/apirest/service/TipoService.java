package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Tipo;
import com.alquiler.apirest.repository.ITipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    private ITipo tipoRepo;

    public Tipo postTipo(Tipo tipo) {
        return tipoRepo.save(tipo);
    }

    public List<Tipo> getAllTipo() {
        return tipoRepo.findAll();
    }

    public Tipo getTipo(int idTipo) {
        return tipoRepo.findById(idTipo).get();
    }

    public boolean deleteTipo(int idTipo) {
        tipoRepo.deleteById(idTipo);
        return tipoRepo.existsById(idTipo);
    }
}