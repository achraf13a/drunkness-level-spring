package com.drunkness.drunknesslevel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drunkness.drunknesslevel.model.Medicion;
import com.drunkness.drunknesslevel.repository.MedicionRepository;

@Service
public class MedicionService {

    private final MedicionRepository repository;

    public MedicionService(MedicionRepository repository) {
        this.repository = repository;
    }

    public List<Medicion> findAll() {
        return repository.findAll();
    }

    public Medicion save(Medicion medicion) {
        // cálculo simple del nivel de alcohol
        double nivel = medicion.getCantidadBebidas() * 0.3;
        medicion.setNivelAlcohol(nivel);
        return repository.save(medicion);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Medicion findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
