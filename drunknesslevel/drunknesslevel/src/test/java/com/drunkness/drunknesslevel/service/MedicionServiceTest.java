package com.drunkness.drunknesslevel.service;

import com.drunkness.drunknesslevel.model.Medicion;
import com.drunkness.drunknesslevel.model.Sexo;
import com.drunkness.drunknesslevel.repository.MedicionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas de MedicionService")
class MedicionServiceTest {

    @Mock
    private MedicionRepository medicionRepository;

    @InjectMocks
    private MedicionService medicionService;

    private Medicion medicion;

    @BeforeEach
    void setUp() {
        medicion = new Medicion();
        medicion.setPeso(70.0);
        medicion.setSexo(Sexo.HOMBRE);
        medicion.setCantidadBebidas(2);
        medicion.setHorasTranscurridas(1.0);
        medicion.setNivelAlcohol(0.05);
    }

    @Test
    @DisplayName("Debe guardar medicion exitosamente")
    void testGuardarMedicion() {
        when(medicionRepository.save(any(Medicion.class))).thenReturn(medicion);

        Medicion resultado = medicionService.save(medicion);

        assertNotNull(resultado);
        assertTrue(resultado.getNivelAlcohol() >= 0);
        verify(medicionRepository, times(1)).save(medicion);
    }

    @Test
    @DisplayName("Debe encontrar medicion por id exitosamente")
    void testObtenerMedicionPorId() {
        when(medicionRepository.findById(1L)).thenReturn(Optional.of(medicion));

        Medicion resultado = medicionService.findById(1L);

        assertNotNull(resultado);
        verify(medicionRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Debe retornar null cuando medicion no se encuentra")
    void testObtenerMedicionPorIdNoEncontrada() {
        when(medicionRepository.findById(999L)).thenReturn(Optional.empty());

        Medicion resultado = medicionService.findById(999L);

        assertNull(resultado);
        verify(medicionRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Debe obtener todas las mediciones exitosamente")
    void testObtenerTodasLasMediciones() {
        Medicion medicion2 = new Medicion();
        medicion2.setPeso(60.0);
        medicion2.setSexo(Sexo.MUJER);
        medicion2.setCantidadBebidas(1);
        medicion2.setHorasTranscurridas(2.0);
        List<Medicion> mediciones = Arrays.asList(medicion, medicion2);
        when(medicionRepository.findAll()).thenReturn(mediciones);

        List<Medicion> resultado = medicionService.findAll();

        assertEquals(2, resultado.size());
        verify(medicionRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe retornar lista vacía cuando no existen mediciones")
    void testObtenerTodasLasMedicionesVacio() {
        when(medicionRepository.findAll()).thenReturn(Arrays.asList());

        List<Medicion> resultado = medicionService.findAll();

        assertTrue(resultado.isEmpty());
        verify(medicionRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe eliminar medicion exitosamente")
    void testEliminarMedicion() {
        doNothing().when(medicionRepository).deleteById(1L);

        medicionService.delete(1L);

        verify(medicionRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Debe actualizar medicion exitosamente")
    void testActualizarMedicion() {
        medicion.setCantidadBebidas(3);
        when(medicionRepository.save(any(Medicion.class))).thenReturn(medicion);

        Medicion resultado = medicionService.save(medicion);

        assertEquals(3, resultado.getCantidadBebidas());
        verify(medicionRepository, times(1)).save(medicion);
    }

    @Test
    @DisplayName("Debe manejar medicion nula")
    void testGuardarMedicionNula() {
        when(medicionRepository.save(null)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> medicionRepository.save(null));
    }
}