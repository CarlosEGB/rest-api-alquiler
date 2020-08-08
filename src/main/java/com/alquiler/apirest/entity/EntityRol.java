package com.alquiler.apirest.entity;

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
public class EntityRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @OneToMany(targetEntity = EntityPersona.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol",
            referencedColumnName = "id_rol",
            foreignKey = @ForeignKey(name = "FK_persona_rol"))
    private List<EntityPersona> entityPersonas;
}
