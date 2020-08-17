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
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colaborador")
    private int idColaborador;

    @Column(length = 50)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "colaboradores")
    private Set<Juego> juegos = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_desarrolladora",
            foreignKey = @ForeignKey(name = "FK_colaborador_desarrolladora"),
            nullable = false)
    private Desarrolladora desarrolladora;

    public Colaborador() {
    }

    public Colaborador(String nombre) {
        this.nombre = nombre;
    }
}
