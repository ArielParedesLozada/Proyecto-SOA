package com.grupo5.grupo5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.grupo5.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
}
