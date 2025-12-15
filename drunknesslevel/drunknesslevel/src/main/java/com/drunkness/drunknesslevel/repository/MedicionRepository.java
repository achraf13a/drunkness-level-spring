package com.drunkness.drunknesslevel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drunkness.drunknesslevel.model.Medicion;

public interface MedicionRepository extends JpaRepository<Medicion, Long> {
}