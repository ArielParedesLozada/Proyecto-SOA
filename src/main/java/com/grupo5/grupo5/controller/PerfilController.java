package com.grupo5.grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.grupo5.grupo5.entity.Estudiante;
import com.grupo5.grupo5.service.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerfilController {
    @Autowired
    private EstudianteService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("estudiantes", this.service.get());
        return "index";
    }

    @GetMapping("/estudiantes/nuevo")
    public String formulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "formulario";
    }

    @PostMapping("/estudiante")
    public String postMethodName(@ModelAttribute Estudiante estudiante) {
        this.service.post(estudiante);
        return "redirect:/";
    }

    @GetMapping("/buscar")
    public String buscarPorCedula(@RequestParam("cedula") String cedula, Model model) {
        Estudiante estudiante = this.service.getByCedula(cedula).orElse(null);

        if (estudiante != null) {
            model.addAttribute("estudiantes", List.of(estudiante));
        } else {
            model.addAttribute("estudiantes", List.of());
            model.addAttribute("mensaje", "No se encontró estudiante con la cédula: " + cedula);
        }

        return "index";
    }

    @GetMapping("/estudiante/{cedula}")
    public String editar(@PathVariable String cedula, Model model) {
        Estudiante estudiante = this.service.getByCedula(cedula).orElseThrow();
        model.addAttribute("estudiante", estudiante);
        return "formulario";
    }

    @DeleteMapping("/estudiante/{cedula}")
    public String eliminar(@PathVariable String cedula) {
        Estudiante estudiante = this.service.getByCedula(cedula).orElseThrow();
        this.service.delete(estudiante);
        return "redirect:/";
    }

    @GetMapping("/estudiante/eliminar/{cedula}")
    public String eliminarPage(@PathVariable String cedula) {
        return this.eliminar(cedula);
    }

}
