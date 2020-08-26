package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.AlquilerJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlquilerJuego extends JpaRepository<AlquilerJuego, Integer> {
}
