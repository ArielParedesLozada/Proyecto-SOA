package com.grupo5.grupo5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.grupo5.entity.Estudiante;
import com.grupo5.grupo5.repository.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repository;

    public List<Estudiante> get(){
        return this.repository.findAll();
    }

    public Optional<Estudiante> getByCedula(String cedula){
        return this.repository.findById(cedula);
    }

    public Estudiante post(Estudiante est){
        return this.repository.save(est);
    }

    public void delete(Estudiante est){
        this.repository.delete(est);
    }
}
