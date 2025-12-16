package com.drunkness.drunknesslevel.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drunkness.drunknesslevel.model.Medicion;
import com.drunkness.drunknesslevel.service.MedicionService;
import java.util.List;

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
    public String guardar(@ModelAttribute Medicion medicion, RedirectAttributes redirectAttributes) {
        service.save(medicion);
        
        List<String> videos = List.of(
        "/videos/anuncio1.mp4",
        "/videos/anuncio2.mp4",
        "/videos/anuncio3.mp4",
        "/videos/anuncio4.mp4",
        "/videos/anuncio5.mp4",
        "/videos/anuncio6.mp4",
        "/videos/anuncio7.mp4",
        "/videos/anuncio8.mp4",
        "/videos/anuncio9.mp4"
        );

        Random random = new Random();
        String videoAleatorio = videos.get(random.nextInt(videos.size()));

        redirectAttributes.addFlashAttribute("mostrarModal", true);
        redirectAttributes.addFlashAttribute("video", videoAleatorio);
        return "redirect:/mediciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/mediciones";
    }
}
