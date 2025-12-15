package com.drunkness.drunknesslevel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drunkness.drunknesslevel.model.Medicion;
import com.drunkness.drunknesslevel.service.MedicionService;

@RestController
@RequestMapping("/api/mediciones")
public class MedicionRestController {

    private final MedicionService service;

    public MedicionRestController(MedicionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medicion> listar() {
        return service.findAll();
    }

    @PostMapping
    public Medicion crear(@RequestBody Medicion medicion) {
        return service.save(medicion);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        service.delete(id);
    }
}
