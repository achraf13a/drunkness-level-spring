package com.drunkness.drunknesslevel.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drunkness.drunknesslevel.model.Medicion;
import com.drunkness.drunknesslevel.model.Sexo;
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

    double gramosAlcohol = medicion.getCantidadBebidas() * 10.0;

    double r = medicion.getSexo() == Sexo.HOMBRE ? 0.68 : 0.55;

    double bac = (gramosAlcohol / (medicion.getPeso() * r))
            - (0.15 * medicion.getHorasTranscurridas());

    if (bac < 0) {
        bac = 0;
    }

    medicion.setNivelAlcohol(Math.round(bac * 1000.0) / 1000.0);

    return repository.save(medicion);
}


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Medicion findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
