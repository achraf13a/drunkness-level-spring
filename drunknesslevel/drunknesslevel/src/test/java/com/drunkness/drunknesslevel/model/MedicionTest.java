package com.drunkness.drunknesslevel.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Medicion Entity Tests")
class MedicionTest {

    @Test
    @DisplayName("should create medicion with default values")
    void testMedicionCreation() {
        // Arrange & Act
        Medicion medicion = new Medicion();
        
        // Assert
        assertNull(medicion.getId());
        assertEquals(0.0, medicion.getPeso());
        assertNull(medicion.getSexo());
        assertEquals(0, medicion.getCantidadBebidas());
        assertEquals(0.0, medicion.getHorasTranscurridas());
        assertEquals(0.0, medicion.getNivelAlcohol());
    }

    @Test
    @DisplayName("should set and get peso correctly")
    void testSetGetPeso() {
        // Arrange
        Medicion medicion = new Medicion();
        double expectedPeso = 75.5;
        
        // Act
        medicion.setPeso(expectedPeso);
        
        // Assert
        assertEquals(expectedPeso, medicion.getPeso());
    }

    @Test
    @DisplayName("should set and get sexo correctly")
    void testSetGetSexo() {
        // Arrange
        Medicion medicion = new Medicion();
        
        // Act
        medicion.setSexo(Sexo.HOMBRE);
        
        // Assert
        assertEquals(Sexo.HOMBRE, medicion.getSexo());
    }

    @Test
    @DisplayName("should set and get cantidadBebidas correctly")
    void testSetGetCantidadBebidas() {
        // Arrange
        Medicion medicion = new Medicion();
        int expectedCantidad = 5;
        
        // Act
        medicion.setCantidadBebidas(expectedCantidad);
        
        // Assert
        assertEquals(expectedCantidad, medicion.getCantidadBebidas());
    }

    @Test
    @DisplayName("should set and get horasTranscurridas correctly")
    void testSetGetHorasTranscurridas() {
        // Arrange
        Medicion medicion = new Medicion();
        double expectedHoras = 3.5;
        
        // Act
        medicion.setHorasTranscurridas(expectedHoras);
        
        // Assert
        assertEquals(expectedHoras, medicion.getHorasTranscurridas());
    }

    @Test
    @DisplayName("should set and get nivelAlcohol correctly")
    void testSetGetNivelAlcohol() {
        // Arrange
        Medicion medicion = new Medicion();
        double expectedNivel = 0.08;
        
        // Act
        medicion.setNivelAlcohol(expectedNivel);
        
        // Assert
        assertEquals(expectedNivel, medicion.getNivelAlcohol());
    }

    @Test
    @DisplayName("should handle negative peso values")
    void testNegativePeso() {
        // Arrange
        Medicion medicion = new Medicion();
        
        // Act
        medicion.setPeso(-50.0);
        
        // Assert
        assertEquals(-50.0, medicion.getPeso());
    }

    @Test
    @DisplayName("should handle zero cantidadBebidas")
    void testZeroCantidadBebidas() {
        // Arrange
        Medicion medicion = new Medicion();
        
        // Act
        medicion.setCantidadBebidas(0);
        
        // Assert
        assertEquals(0, medicion.getCantidadBebidas());
    }

    @Test
    @DisplayName("should return null id before persistence")
    void testGetIdBeforePersistence() {
        // Arrange
        Medicion medicion = new Medicion();
        
        // Assert
        assertNull(medicion.getId());
    }
}
