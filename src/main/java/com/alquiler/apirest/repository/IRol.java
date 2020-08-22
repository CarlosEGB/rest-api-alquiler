package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRol extends JpaRepository<Rol, Integer> {
}
