package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlataforma extends JpaRepository<Plataforma,Integer> {
}
