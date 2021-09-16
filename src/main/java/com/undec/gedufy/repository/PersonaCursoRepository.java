package com.undec.gedufy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.undec.gedufy.model.PersonaCurso;

public interface PersonaCursoRepository extends JpaRepository<PersonaCurso, Integer> {
}