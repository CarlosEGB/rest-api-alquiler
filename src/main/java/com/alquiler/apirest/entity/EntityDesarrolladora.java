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
@Table(name = "desarrolladora")
public class EntityDesarrolladora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desarrolladora")
    private int idDesarrolladora;

    @Column(length = 50)
    private String nombre;

    @OneToMany(targetEntity = EntityColaborador.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_desarrolladora",
            referencedColumnName = "id_desarrolladora",
            foreignKey = @ForeignKey(name = "FK_colaborador_desarrolladora"),
            nullable = false)
    private List<EntityColaborador> entityColaboradors;
}
