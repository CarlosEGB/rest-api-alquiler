package com.alquiler.apirest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private int idAlquiler;

    @Column(name = "monto_total")
    private int montoTotal;

    @JsonFormat(pattern = "yyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_incial")
    private Date fechaInicial;

    @OneToMany(mappedBy = "alquiler")
    private List<AlquilerJuego> alquilerJuegos = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_persona",
            foreignKey = @ForeignKey(name = "FK_alquiler_persona"),
            nullable = false)
    private Persona persona;

    public Alquiler() {
    }

    public Alquiler(int montoTotal, Date fechaInicial) {
        this.montoTotal = montoTotal;
        this.fechaInicial = fechaInicial;
    }
}
