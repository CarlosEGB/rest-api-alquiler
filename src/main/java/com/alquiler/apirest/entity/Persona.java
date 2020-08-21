package com.alquiler.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "persona", uniqueConstraints = @UniqueConstraint(name = "UK_dni", columnNames = {"dni"}))
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int idPersona;

    @Column(nullable = false)
    private int dni;

    @Column(length = 50)
    private String nombre;

    @Temporal(TemporalType.DATE)
    private Date nacimiento;

    @Column(nullable = true)
    private int telefono;

    @OneToMany(targetEntity = Alquiler.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona",
            referencedColumnName = "id_persona",
            foreignKey = @ForeignKey(name = "FK_alquiler_persona"),
            nullable = false)
    @JsonIgnore
    private List<Alquiler> alquileres = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_rol",
            foreignKey = @ForeignKey(name = "FK_persona_rol"),
            nullable = false)
    private Rol rol;

    public Persona() {
    }

    public Persona(int dni, String nombre, Date nacimiento, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
    }
}
