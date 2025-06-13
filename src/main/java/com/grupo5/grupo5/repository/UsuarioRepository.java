package com.grupo5.grupo5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo5.grupo5.entity.Usuario;
import java.util.List;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByEmail(String email);
    List<Usuario> findByRole(String role);
}
