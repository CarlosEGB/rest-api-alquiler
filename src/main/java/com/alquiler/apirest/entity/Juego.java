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
@Table(name = "juego")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private int idJuego;

    @Column(length = 50)
    private String nombre;

    @Temporal(TemporalType.DATE)
    private Date lanzamiento;

    @Column(nullable = true)
    private int precio;

    @Column(nullable = true)
    private int Stock;

    @OneToMany(targetEntity = AlquilerJuego.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "id_juego",
            referencedColumnName = "id_juego",
            foreignKey = @ForeignKey(name = "FK_alqui_juego_juego"),
            nullable = false)
    private List<AlquilerJuego> alquilerJuegos;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "colaborador_juego",
            joinColumns = {@JoinColumn(name = "id_juego",
                    foreignKey = @ForeignKey(name = "FK_colabora_juego_juego"),
                    nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_colaborador",
                    foreignKey = @ForeignKey(name = "FK_colabora_juego_colabora"),
                    nullable = false)})
    private List<Colaborador> colaboradores;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name = "protagonista_juego",
            joinColumns = {@JoinColumn(name = "id_juego",
                    foreignKey = @ForeignKey(name = "FK_protago_juego_juego"),
                    nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_protagonista",
                    foreignKey = @ForeignKey(name = "FK_protago_juego_protagonista"),
                    nullable = false)})
    private List<Protagonista> protagonistas;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "plataforma_juego",
            joinColumns = {@JoinColumn(name = "id_juego",
                    foreignKey = @ForeignKey(name = "FK_platf_juego_juego"),
                    nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_plataforma",
                    foreignKey = @ForeignKey(name = "FK_platf_juego_plataforma"),
                    nullable = false)})
    private List<Plataforma> plataformas;
}
