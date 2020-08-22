package com.alquiler.apirest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "alquiler_juego")
public class AlquilerJuego {

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

    @JsonFormat(pattern = "yyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_final")
    private Date fechaFinal;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_alquiler",
            foreignKey = @ForeignKey(name = "FK_alqui_juego_alqui"),
            nullable = false)
    @JsonIgnore
    private Alquiler alquiler;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_juego",
            foreignKey = @ForeignKey(name = "FK_alqui_juego_juego"),
            nullable = false)
    private Juego juego;

    public AlquilerJuego() {
    }

    public AlquilerJuego(boolean estado, int cantidad, int periodo, int valorTotal, Date fechaFinal) {
        this.estado = estado;
        this.cantidad = cantidad;
        this.periodo = periodo;
        this.valorTotal = valorTotal;
        this.fechaFinal = fechaFinal;
    }
}
