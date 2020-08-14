package com.alquiler.apirest.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @OneToMany(targetEntity = Colaborador.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_desarrolladora",
            referencedColumnName = "id_desarrolladora",
            foreignKey = @ForeignKey(name = "FK_colaborador_desarrolladora"),
            nullable = false)
    private List<Colaborador> colaboradores;

    public Desarrolladora() {
    }

    public Desarrolladora(String nombre) {
        this.nombre = nombre;
    }
}

