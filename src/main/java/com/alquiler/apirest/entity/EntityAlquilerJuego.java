package com.alquiler.apirest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "alquiler_juego")
public class EntityAlquilerJuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alqui_juego")
    private int idAlquilerJuego;

    @Column(columnDefinition = "BOOLEAN")
    private boolean estado;

    @Column(nullable = true)
    private int cantidad;

    @Column(nullable = true)
    private int periodo;

    @Column(name = "valor_total")
    private int valorTotal;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_final")
    private Date fechaFinal;
}
