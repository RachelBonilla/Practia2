package com.practica1.controller;

import com.practica1.domain.Arbol;
import com.practica1.service.ArbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String listarArboles(Model model) {
        List<Arbol> arboles = arbolService.getArboles(true);
        model.addAttribute("arboles", arboles);
        return "arbol/listado"; // Vista para mostrar listado de árboles
    }

    @GetMapping("/nuevo")
    public String crearArbol(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "arbol/form"; // Vista para crear nuevo árbol
    }

    @PostMapping("/guardar")
    public String guardarArbol(@ModelAttribute Arbol arbol) {
        arbolService.save(arbol);
        return "redirect:/arbol/listado"; // Redirige a listado después de guardar
    }

    @GetMapping("/modificar/{idArbol}")
    public String modificarArbol(@PathVariable Long idArbol, Model model) {
        Arbol arbol = arbolService.getArbol(new Arbol(idArbol));
        if (arbol == null) {
            model.addAttribute("error", "Árbol no encontrado");
            return "arbol/error"; // Vista para mostrar error
        }
        model.addAttribute("arbol", arbol);
        return "arbol/form"; // Vista para modificar árbol
    }

    @GetMapping("/eliminar/{idArbol}")
    public String eliminarArbol(@PathVariable Long idArbol) {
        arbolService.delete(new Arbol(idArbol));
        return "redirect:/arbol/listado"; // Redirige a listado después de eliminar
    }
}
