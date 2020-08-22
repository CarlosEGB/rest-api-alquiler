package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends JpaRepository<Persona, Integer> {
}
