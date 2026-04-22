package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "videojuegos")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private Double precio;
    private LocalDate fechaLanzamiento;
    private Double valoracionMedia;

    @ManyToOne
    @JoinColumn(name = "estudio_id")
    private Estudio estudio;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL)
    private List<Resena> resenas;

    public Videojuego() {}

    public Videojuego(String titulo, String genero, Double precio, LocalDate fechaLanzamiento, Double valoracionMedia, Estudio estudio) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
        this.fechaLanzamiento = fechaLanzamiento;
        this.valoracionMedia = valoracionMedia;
        this.estudio = estudio;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public LocalDate getFechaLanzamiento() { return fechaLanzamiento; }
    public void setFechaLanzamiento(LocalDate fechaLanzamiento) { this.fechaLanzamiento = fechaLanzamiento; }
    public Double getValoracionMedia() { return valoracionMedia; }
    public void setValoracionMedia(Double valoracionMedia) { this.valoracionMedia = valoracionMedia; }
    public Estudio getEstudio() { return estudio; }
    public void setEstudio(Estudio estudio) { this.estudio = estudio; }
    public List<Resena> getResenas() { return resenas; }
    public void setResenas(List<Resena> resenas) { this.resenas = resenas; }
}