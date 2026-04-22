package com.example.demo.controller;

import com.example.demo.entity.Resena;
import com.example.demo.service.ResenaService;
import com.example.demo.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @Autowired
    private ResenaRepository resenaRepository;

    @PostMapping("/videojuego/{videojuegoId}")
    public Resena crear(@RequestBody Resena resena, @PathVariable Long videojuegoId) {
        return resenaService.crearResenaYActualizarValoracion(resena, videojuegoId);
    }


    @GetMapping("/videojuego/{videojuegoId}")
    public List<Resena> listarPorVideojuego(@PathVariable Long videojuegoId) {
        return resenaRepository.findByVideojuegoId(videojuegoId);
    }

    @GetMapping("/puntuacion-minima/{puntos}")
    public List<Resena> filtrarPorPuntuacion(@PathVariable Integer puntos) {
        return resenaRepository.findByPuntuacionGreaterThanEqual(puntos);
    }
}