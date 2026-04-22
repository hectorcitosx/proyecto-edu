package com.example.demo.repository;

import com.example.demo.entity.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    
   
    List<Videojuego> findByPrecioGreaterThan(Double precio);
    
    
    List<Videojuego> findAllByOrderByValoracionMediaDesc();
    
    
    List<Videojuego> findByEstudioId(Long estudioId);
}
