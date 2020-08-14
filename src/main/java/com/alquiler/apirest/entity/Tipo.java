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
@Table(name = "tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private int idTipo;

    @Column(length = 50)
    private String nombre;

    @OneToMany(targetEntity = Colaborador.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo",
            referencedColumnName = "id_tipo",
            foreignKey = @ForeignKey(name = "FK_colaborador_tipo"),
            nullable = false)
    private List<Colaborador> colaboradores;

    public Tipo() {
    }

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

}
