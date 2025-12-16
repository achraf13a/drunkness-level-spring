package com.drunkness.drunknesslevel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double peso;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private int cantidadBebidas;

    private double horasTranscurridas;

    private double nivelAlcohol;

    // GETTERS Y SETTERS

    public Long getId() { return id; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public Sexo getSexo() { return sexo; }
    public void setSexo(Sexo sexo) { this.sexo = sexo; }

    public int getCantidadBebidas() { return cantidadBebidas; }
    public void setCantidadBebidas(int cantidadBebidas) {
        this.cantidadBebidas = cantidadBebidas;
    }

    public double getHorasTranscurridas() { return horasTranscurridas; }
    public void setHorasTranscurridas(double horasTranscurridas) {
        this.horasTranscurridas = horasTranscurridas;
    }

    public double getNivelAlcohol() { return nivelAlcohol; }
    public void setNivelAlcohol(double nivelAlcohol) {
        this.nivelAlcohol = nivelAlcohol;
    }
}
