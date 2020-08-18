package com.alquiler.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(targetEntity = Persona.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol",
            referencedColumnName = "id_rol",
            foreignKey = @ForeignKey(name = "FK_persona_rol"))
    @JsonIgnore
    private List<Persona> personas;
}
