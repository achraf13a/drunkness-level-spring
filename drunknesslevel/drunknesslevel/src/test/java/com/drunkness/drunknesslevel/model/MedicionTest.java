package com.drunkness.drunknesslevel.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Medicion Entity Tests")
class MedicionTest {

    @Test
    @DisplayName("Debe crear medicion con valores por defecto")
    void testMedicionCreation() {
        Medicion medicion = new Medicion();
        
        assertNull(medicion.getId());
        assertEquals(0.0, medicion.getPeso());
        assertNull(medicion.getSexo());
        assertEquals(0, medicion.getCantidadBebidas());
        assertEquals(0.0, medicion.getHorasTranscurridas());
        assertEquals(0.0, medicion.getNivelAlcohol());
    }

    @Test
    @DisplayName("Debe establecer y obtener peso correctamente")
    void testSetGetPeso() {
        Medicion medicion = new Medicion();
        double expectedPeso = 75.5;
        
        medicion.setPeso(expectedPeso);
        
        assertEquals(expectedPeso, medicion.getPeso());
    }

    @Test
    @DisplayName("Debe establecer y obtener sexo correctamente")
    void testSetGetSexo() {
        Medicion medicion = new Medicion();
        
        medicion.setSexo(Sexo.HOMBRE);
        
        assertEquals(Sexo.HOMBRE, medicion.getSexo());
    }

    @Test
    @DisplayName("Debe establecer y obtener cantidadBebidas correctamente")
    void testSetGetCantidadBebidas() {
        Medicion medicion = new Medicion();
        int expectedCantidad = 5;
        
        medicion.setCantidadBebidas(expectedCantidad);
        
        assertEquals(expectedCantidad, medicion.getCantidadBebidas());
    }

    @Test
    @DisplayName("Debe establecer y obtener horasTranscurridas correctamente")
    void testSetGetHorasTranscurridas() {
        Medicion medicion = new Medicion();
        double expectedHoras = 3.5;
        
        medicion.setHorasTranscurridas(expectedHoras);
        
        assertEquals(expectedHoras, medicion.getHorasTranscurridas());
    }

    @Test
    @DisplayName("Debe establecer y obtener nivelAlcohol correctamente")
    void testSetGetNivelAlcohol() {
        Medicion medicion = new Medicion();
        double expectedNivel = 0.08;
        
        medicion.setNivelAlcohol(expectedNivel);
        
        assertEquals(expectedNivel, medicion.getNivelAlcohol());
    }

    @Test
    @DisplayName("Debe manejar valores de peso negativos")
    void testNegativePeso() {
        Medicion medicion = new Medicion();
        
        medicion.setPeso(-50.0);
        
        assertEquals(-50.0, medicion.getPeso());
    }

    @Test
    @DisplayName("Debe manejar cantidad de bebidas en cero")
    void testZeroCantidadBebidas() {
        Medicion medicion = new Medicion();
        medicion.setCantidadBebidas(0);
        
        assertEquals(0, medicion.getCantidadBebidas());
    }

    @Test
    @DisplayName("Debe retornar null id antes de persistencia")
    void testGetIdBeforePersistence() {
        Medicion medicion = new Medicion();
        
        assertNull(medicion.getId());
    }
}
