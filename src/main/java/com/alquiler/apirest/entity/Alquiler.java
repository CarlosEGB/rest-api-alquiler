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
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private int idAlquiler;

    @Column(name = "monto_total")
    private int montoTotal;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_incial")
    private Date fechaInicial;

    @OneToMany(targetEntity = AlquilerJuego.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_alquiler",
            referencedColumnName = "id_alquiler",
            foreignKey = @ForeignKey(name = "FK_alqui_juego_alqui"),
            nullable = false)
    private List<AlquilerJuego> alquilerJuegos;
}
