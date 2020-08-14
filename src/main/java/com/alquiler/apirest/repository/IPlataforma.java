package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlataforma extends JpaRepository<Plataforma,Integer> {
}
