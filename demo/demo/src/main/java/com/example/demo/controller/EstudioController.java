package com.example.demo.controller;

import com.example.demo.entity.Estudio;
import com.example.demo.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudios")
public class EstudioController {

    @Autowired
    private EstudioRepository estudioRepository;

    @GetMapping
    public List<Estudio> listarTodos() {
        return estudioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudio> obtenerPorId(@PathVariable Long id) {
        return estudioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudio> crear(@RequestBody Estudio estudio) {
        return new ResponseEntity<>(estudioRepository.save(estudio), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudio> actualizar(@PathVariable Long id, @RequestBody Estudio detalles) {
        return estudioRepository.findById(id).map(estudio -> {
            estudio.setNombre(detalles.getNombre());
            estudio.setPais(detalles.getPais());
            estudio.setAnioFundacion(detalles.getAnioFundacion());
            return ResponseEntity.ok(estudioRepository.save(estudio));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (estudioRepository.existsById(id)) {
            estudioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}