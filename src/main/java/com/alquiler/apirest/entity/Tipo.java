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
@Table(name = "tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private int idTipo;

    @Column(length = 50)
    private String nombre;

    @OneToMany(mappedBy = "tipo")
    @JsonIgnore
    private List<Colaborador> colaboradores = new ArrayList<>();

    public Tipo() {
    }

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

}
