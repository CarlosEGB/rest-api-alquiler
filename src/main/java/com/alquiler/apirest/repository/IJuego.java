package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJuego extends JpaRepository<Juego, Integer> {
}
