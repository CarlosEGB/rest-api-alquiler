package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Desarrolladora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDesarrolladora extends JpaRepository<Desarrolladora, Integer> {
}
