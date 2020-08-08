package com.alquiler.apirest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Alquiler> alquileres;
}
