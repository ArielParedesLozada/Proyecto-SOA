package com.grupo5.grupo5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.grupo5.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
    
}
