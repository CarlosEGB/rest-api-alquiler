package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Colaborador;
import com.alquiler.apirest.repository.IColaborador;
import com.alquiler.apirest.repository.IDesarrolladora;
import com.alquiler.apirest.repository.ITipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {

    @Autowired
    private IColaborador colaboradorRepo;

    @Autowired
    private IDesarrolladora desarrolladoraRepo;

    @Autowired
    private ITipo tipoRepo;

    public Colaborador postColaborador(Colaborador colaborador) {

        Colaborador saveColaborador = new Colaborador();
        saveColaborador.setNombre(colaborador.getNombre());
        saveColaborador.setDesarrolladora(desarrolladoraRepo.findById(colaborador.getDesarrolladora().getIdDesarrolladora()).get());
        saveColaborador.setTipo(tipoRepo.findById(colaborador.getTipo().getIdTipo()).get());

        return colaboradorRepo.save(saveColaborador);
    }

    public List<Colaborador> getAllColaboradores() {
        return colaboradorRepo.findAll();
    }

    public Colaborador getColabarador(int idColaborador) {
        return colaboradorRepo.findById(idColaborador).get();
    }

    public boolean deleteColaborador(int idColaborador) {
        colaboradorRepo.deleteById(idColaborador);
        return colaboradorRepo.existsById(idColaborador);
    }
}