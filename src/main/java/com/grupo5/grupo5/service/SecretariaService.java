package com.grupo5.grupo5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.grupo5.entity.Usuario;
import com.grupo5.grupo5.repository.UsuarioRepository;

@Service
public class SecretariaService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return this.repository.findByRole("ROLE_secretaria");
    }

    public Optional<Usuario> getByEmail(String email){
        Optional<Usuario> secretaria =  this.repository.findById(email);
        if (secretaria.isEmpty()) {
            return secretaria;
        }
        if (!secretaria.get().getRole().equals("ROLE_secretaria")) {
            throw new Error("No autorizado");
        }
        return secretaria;
    }

    public Usuario save(Usuario usuario){
        if (!usuario.getRole().equals("ROLE_secretaria")) {
            throw new Error("Solo se pueden crear secretarias");
        }
        return this.repository.save(usuario);
    }
}
