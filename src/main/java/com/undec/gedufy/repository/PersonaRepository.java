package com.undec.gedufy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.undec.gedufy.model.Persona;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findAllByNombreContaining(String nombre);

    boolean findByEmail(String email);
}