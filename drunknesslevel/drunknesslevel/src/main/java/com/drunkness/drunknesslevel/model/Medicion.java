package com.drunkness.drunknesslevel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double peso;
    private String sexo;
    private int cantidadBebidas;
    private double nivelAlcohol;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public int getCantidadBebidas() { return cantidadBebidas; }
    public void setCantidadBebidas(int cantidadBebidas) {
        this.cantidadBebidas = cantidadBebidas;
    }

    public double getNivelAlcohol() { return nivelAlcohol; }
    public void setNivelAlcohol(double nivelAlcohol) {
        this.nivelAlcohol = nivelAlcohol;
    }
}
