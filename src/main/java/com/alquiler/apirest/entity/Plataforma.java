package com.alquiler.apirest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "plataforma")
public class Plataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plataforma")
    private int idPlataforma;

    @Column(length = 50)
    private String nombre;

    @ToString.Exclude
    @ManyToMany(targetEntity = Juego.class, fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "plataformas")
    private Set<Juego> juegos = new HashSet<>();

    public Plataforma() {
    }

    public Plataforma(String nombre) {
        this.nombre = nombre;
    }
}
