package com.example.demo.service;

import com.example.demo.entity.Resena;
import com.example.demo.entity.Videojuego;
import com.example.demo.repository.ResenaRepository;
import com.example.demo.repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Transactional
    public Resena crearResenaYActualizarValoracion(Resena nuevaResena, Long videojuegoId) {
        
        Videojuego videojuego = videojuegoRepository.findById(videojuegoId)
                .orElseThrow(() -> new RuntimeException("Videojuego no encontrado"));


        nuevaResena.setVideojuego(videojuego);

        Resena resenaGuardada = resenaRepository.save(nuevaResena);

        List<Resena> todasLasResenas = resenaRepository.findByVideojuegoId(videojuegoId);
        
        double sumaPuntuaciones = 0;
        for (Resena r : todasLasResenas) {
            sumaPuntuaciones += r.getPuntuacion();
        }
        
        double nuevaMedia = sumaPuntuaciones / todasLasResenas.size();
        videojuego.setValoracionMedia(nuevaMedia);

        videojuegoRepository.save(videojuego);

        return resenaGuardada;
    }
}