package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudios")
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;
    private Integer anioFundacion;

    @OneToMany(mappedBy = "estudio", cascade = CascadeType.ALL)
    private List<Videojuego> videojuegos;

    public Estudio() {
    }

    public Estudio(String nombre, String pais, Integer anioFundacion) {
        this.nombre = nombre;
        this.pais = pais;
        this.anioFundacion = anioFundacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public Integer getAnioFundacion() { return anioFundacion; }
    public void setAnioFundacion(Integer anioFundacion) { this.anioFundacion = anioFundacion; }

    public List<Videojuego> getVideojuegos() { return videojuegos; }
    public void setVideojuegos(List<Videojuego> videojuegos) { this.videojuegos = videojuegos; }
}