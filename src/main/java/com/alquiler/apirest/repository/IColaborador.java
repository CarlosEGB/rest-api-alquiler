package com.alquiler.apirest.repository;

import com.alquiler.apirest.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IColaborador extends JpaRepository<Colaborador,Integer> {

}
