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
@Table(name = "tipo")
public class EntityTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private int idTipoColaborador;

    @Column(length = 50)
    private String nombre;

    @OneToMany(targetEntity = EntityPersona.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo",
            referencedColumnName = "id_tipo",
            foreignKey = @ForeignKey(name = "FK_colaborador_tipo"),
            nullable = false)
    private List<EntityColaborador> entityColaboradors;
}
