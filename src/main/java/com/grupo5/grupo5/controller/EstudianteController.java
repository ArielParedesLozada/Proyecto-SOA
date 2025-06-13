package com.grupo5.grupo5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.grupo5.grupo5.entity.Estudiante;
import com.grupo5.grupo5.service.EstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @GetMapping("/estudiantes")
    public String index(Model model) {
        model.addAttribute("estudiantes", this.service.get());
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes";
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

        return "estudiantes";
    }

    @PostMapping("/estudiante")
    @PreAuthorize("hasRole('admin')")
    public String guardar(@ModelAttribute Estudiante estudiante) {
        this.service.post(estudiante);
        return "redirect:/user/estudiantes";
    }

    @GetMapping("/estudiante/editar/{cedula}")
    @PreAuthorize("hasRole('admin')")
    public String editar(@PathVariable String cedula, Model model) {
        Estudiante estudiante = this.service.getByCedula(cedula).orElseThrow();
        model.addAttribute("estudiante", estudiante);
        return "formulario";
    }

    @GetMapping("/estudiante/eliminar/{cedula}")
    @PreAuthorize("hasRole('admin')")
    public String eliminar(@PathVariable String cedula) {
        Estudiante estudiante = this.service.getByCedula(cedula).orElseThrow();
        this.service.delete(estudiante);
        return "redirect:/user/estudiantes";
    }
}
