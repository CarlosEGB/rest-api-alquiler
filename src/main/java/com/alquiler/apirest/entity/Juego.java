package com.alquiler.apirest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "juego")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private int idJuego;

    @Column(length = 50)
    private String nombre;

    @JsonFormat(pattern = "yyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Temporal(TemporalType.DATE)
    private Date lanzamiento;

    @Column(nullable = true)
    private int precio;

    @Column(nullable = true)
    private int stock;

    @OneToMany(mappedBy = "juego")
    @JsonIgnore
    private List<AlquilerJuego> alquilerJuegos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinTable(name = "colaborador_juego",
            joinColumns = {@JoinColumn(name = "id_juego",
                    foreignKey = @ForeignKey(name = "FK_colabora_juego_juego"),
                    nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_colaborador",
                    foreignKey = @ForeignKey(name = "FK_colabora_juego_colabora"),
                    nullable = false)})
    @JsonIgnoreProperties("juegos")
    private Set<Colaborador> colaboradores = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinTable(name = "protagonista_juego",
            joinColumns = {@JoinColumn(name = "id_juego",
                    foreignKey = @ForeignKey(name = "FK_protago_juego_juego"),
                    nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_protagonista",
                    foreignKey = @ForeignKey(name = "FK_protago_juego_protagonista"),
                    nullable = false)})
    @JsonIgnoreProperties("juegos")
    private Set<Protagonista> protagonistas = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "plataforma_juego",
            joinColumns = {@JoinColumn(name = "id_juego",
                    foreignKey = @ForeignKey(name = "FK_platf_juego_juego"),
                    nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_plataforma",
                    foreignKey = @ForeignKey(name = "FK_platf_juego_plataforma"),
                    nullable = false)})
    @JsonIgnoreProperties("juegos")
    private Set<Plataforma> plataformas = new HashSet<>();

    public Juego() {
    }

    public Juego(String nombre, Date lanzamiento, int precio, int stock) {
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
        this.precio = precio;
        this.stock = stock;
    }
}
