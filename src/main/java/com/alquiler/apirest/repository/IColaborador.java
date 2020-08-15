package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColaborador extends JpaRepository<Colaborador, Integer> {

}
