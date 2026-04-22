package com.example.demo.repository;

import com.example.demo.entity.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {
    
    List<Resena> findByPuntuacionGreaterThanEqual(Integer puntuacion);
    
    List<Resena> findByVideojuegoId(Long videojuegoId);
}