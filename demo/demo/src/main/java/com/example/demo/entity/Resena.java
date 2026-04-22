package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;
    private String comentario;
    private Integer puntuacion;
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "videojuego_id")
    private Videojuego videojuego;

    public Resena() {}

    public Resena(String autor, String comentario, Integer puntuacion, LocalDate fecha, Videojuego videojuego) {
        this.autor = autor;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.videojuego = videojuego;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public Integer getPuntuacion() { return puntuacion; }
    public void setPuntuacion(Integer puntuacion) { this.puntuacion = puntuacion; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public Videojuego getVideojuego() { return videojuego; }
    public void setVideojuego(Videojuego videojuego) { this.videojuego = videojuego; }
}