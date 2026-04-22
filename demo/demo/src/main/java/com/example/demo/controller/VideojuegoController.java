package com.example.demo.controller;

import com.example.demo.entity.Videojuego;
import com.example.demo.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @GetMapping
    public List<Videojuego> listarTodos() {
        return videojuegoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Videojuego> crear(@RequestBody Videojuego videojuego) {
        return new ResponseEntity<>(videojuegoRepository.save(videojuego), HttpStatus.CREATED);
    }

    @GetMapping("/precio-mayor/{cantidad}")
    public List<Videojuego> filtrarPorPrecio(@PathVariable Double cantidad) {
        return videojuegoRepository.findByPrecioGreaterThan(cantidad);
    }

    @GetMapping("/ordenados-valoracion")
    public List<Videojuego> listarOrdenadosPorValoracion() {
        return videojuegoRepository.findAllByOrderByValoracionMediaDesc();
    }

    @GetMapping("/estudio/{estudioId}")
    public List<Videojuego> listarPorEstudio(@PathVariable Long estudioId) {
        return videojuegoRepository.findByEstudioId(estudioId);
    }
}