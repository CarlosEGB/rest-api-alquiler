package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Protagonista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProtagonista extends JpaRepository<Protagonista,Integer> {
}
