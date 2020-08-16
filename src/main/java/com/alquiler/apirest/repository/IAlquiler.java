package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlquiler extends JpaRepository<Alquiler, Integer> {
}
