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
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private List<Persona> personas = new ArrayList<>();

    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
