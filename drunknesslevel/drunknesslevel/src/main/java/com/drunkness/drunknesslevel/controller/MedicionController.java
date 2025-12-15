package com.drunkness.drunknesslevel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drunkness.drunknesslevel.model.Medicion;
import com.drunkness.drunknesslevel.service.MedicionService;

@Controller
@RequestMapping("/mediciones")
public class MedicionController {

    private final MedicionService service;

    public MedicionController(MedicionService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mediciones", service.findAll());
        model.addAttribute("medicion", new Medicion());
        return "mediciones";
    }

    @PostMapping
    public String guardar(@ModelAttribute Medicion medicion) {
        service.save(medicion);
        return "redirect:/mediciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/mediciones";
    }
}
