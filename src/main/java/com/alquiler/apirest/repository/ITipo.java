package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipo extends JpaRepository<Tipo, Integer> {

}
