package com.alquiler.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "protagonista")
public class Protagonista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_protagonista")
    private int idProtagonista;

    @Column(length = 50)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "protagonistas")
    @JsonIgnore
    private Set<Juego> juegos = new HashSet<>();

    public Protagonista() {
    }

    public Protagonista(String nombre) {
        this.nombre = nombre;
    }
}
