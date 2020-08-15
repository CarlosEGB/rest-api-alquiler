package com.alquiler.apirest.service;

import com.alquiler.apirest.entity.Colaborador;
import com.alquiler.apirest.entity.Juego;
import com.alquiler.apirest.entity.Plataforma;
import com.alquiler.apirest.entity.Protagonista;
import com.alquiler.apirest.repository.IColaborador;
import com.alquiler.apirest.repository.IJuego;
import com.alquiler.apirest.repository.IPlataforma;
import com.alquiler.apirest.repository.IProtagonista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JuegoService {

    @Autowired
    private IJuego juegoRepo;

    @Autowired
    private IPlataforma plataformaRepo;

    @Autowired
    private IProtagonista protagonistaRepo;

    @Autowired
    private IColaborador colaboradorRepo;

    public Juego guardarJuego(Juego bodyJuego) {

        Juego saveJuego = new Juego();

        saveJuego.setNombre(bodyJuego.getNombre());
        saveJuego.setLanzamiento(bodyJuego.getLanzamiento());
        saveJuego.setPrecio(bodyJuego.getPrecio());
        saveJuego.setStock(bodyJuego.getPrecio());

        List<Colaborador> colaboradorList = new ArrayList<>();
        for (Colaborador colaborador : bodyJuego.getColaboradores()) {
            int idColaborador = colaborador.getIdColaborador();
            colaboradorList.add(colaboradorRepo.findById(idColaborador).get());
        }
        saveJuego.getColaboradores().addAll(colaboradorList);

        List<Protagonista> protagonistaList = new ArrayList<>();
        for (Protagonista protagonista : bodyJuego.getProtagonistas()) {
            int idProtagonista = protagonista.getIdProtagonista();
            protagonistaList.add(protagonistaRepo.findById(idProtagonista).get());
        }
        saveJuego.getProtagonistas().addAll(protagonistaList);

        List<Plataforma> plataformaList = new ArrayList<>();
        for (Plataforma plataforma : bodyJuego.getPlataformas()) {
            int idPlataforma = plataforma.getIdPlataforma();
            plataformaList.add(plataformaRepo.findById(idPlataforma).get());
        }
        saveJuego.getPlataformas().addAll(plataformaList);

        return juegoRepo.save(saveJuego);
    }

    public Juego getJuego(int idJuego){
        return juegoRepo.findById(idJuego).get();
    }

    public List<Juego> getJuegos() {
        return juegoRepo.findAll();
    }

    public Boolean deleteJuegoById(int idJUego) {
        juegoRepo.deleteById(idJUego);
        return juegoRepo.existsById(idJUego);
    }
}
