package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Alquiler;
import com.alquiler.apirest.entity.AlquilerJuego;
import com.alquiler.apirest.entity.Persona;
import com.alquiler.apirest.repository.IAlquiler;
import com.alquiler.apirest.repository.IAlquilerJuego;
import com.alquiler.apirest.repository.IJuego;
import com.alquiler.apirest.repository.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlquillerService {

    @Autowired
    private IAlquiler alquilerRepo;

    @Autowired
    private IPersona personaRepo;

    @Autowired
    private IAlquilerJuego alquilerJuegoRepo;

    @Autowired
    private IJuego juegoRepo;

    public Alquiler postAlquiler(Alquiler alquiler) {

        Alquiler saveAlquiler = new Alquiler();
        saveAlquiler.setFechaInicial(alquiler.getFechaInicial());
        saveAlquiler.setMontoTotal(alquiler.getMontoTotal());

        Persona persona = personaRepo.findById(alquiler.getPersona().getIdPersona()).get();
        saveAlquiler.setPersona(persona);

        Alquiler responseAlquiler = alquilerRepo.save(saveAlquiler);

        List<AlquilerJuego> alquilerJuegoList = new ArrayList<>();

        for (AlquilerJuego alquilerJuego : alquiler.getAlquilerJuegos()) {
            alquilerJuego.setJuego(juegoRepo.findById(alquilerJuego.getJuego().getIdJuego()).get());
            alquilerJuego.setAlquiler(responseAlquiler);
            alquilerJuegoList.add(alquilerJuegoRepo.save(alquilerJuego));
        }

        saveAlquiler.getAlquilerJuegos().addAll(alquilerJuegoList);

        return alquilerRepo.save(saveAlquiler);
    }

    public List<Alquiler> getAllAlquiler() {
        return alquilerRepo.findAll();
    }

    public Alquiler getAlquiler(int idAlquiler) {
        return alquilerRepo.findById(idAlquiler).get();
    }

    public Boolean deleteAlquiler(int idAlquiler) {
        alquilerRepo.deleteById(idAlquiler);
        return alquilerRepo.existsById(idAlquiler);
    }
}
