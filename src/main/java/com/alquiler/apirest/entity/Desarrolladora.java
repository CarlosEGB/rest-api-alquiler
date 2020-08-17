package com.alquiler.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "desarrolladora")
public class Desarrolladora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desarrolladora")
    private int idDesarrolladora;

    @Column(length = 50)
    private String nombre;

    @OneToMany(mappedBy = "desarrolladora")
    @JsonIgnore
    private List<Colaborador> colaboradores = new ArrayList<>();

    public Desarrolladora() {
    }

    public Desarrolladora(String nombre) {
        this.nombre = nombre;
    }
}

