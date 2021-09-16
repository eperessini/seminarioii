package com.undec.gedufy.dto;

import com.undec.gedufy.model.Curso;
import com.undec.gedufy.model.Persona;
import com.undec.gedufy.model.PersonaCurso;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PersonaCursoDTO {
    private Integer id;
    private String observacion;
    private PersonaDTO personaDTO;
    private CursoDTO cursoDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public PersonaDTO getPersonaDTO() {
        return personaDTO;
    }

    public void setPersonaDTO(PersonaDTO personaDTO) {
        this.personaDTO = personaDTO;
    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    public PersonaCurso getPersonaCurso(PersonaCursoDTO personaCursoDTO, Curso curso, Persona persona) {
        PersonaCurso personaCurso = new PersonaCurso();
        personaCurso.setObservacion(personaCursoDTO.getObservacion());
        personaCurso.setCurso(curso);
        personaCurso.setPersona(persona);
        personaCurso.setCreatedBy("anonimo");
        personaCurso.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        personaCurso.setUpdatedBy("anonimo");
        personaCurso.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return personaCurso;
    }

    public List<PersonaCursoDTO> getPersonaCursoDTOList(List<PersonaCurso> PersonaCursoList) {
        List<PersonaCursoDTO> personaCursoDTOList = new ArrayList<>();

        for (PersonaCurso item : PersonaCursoList) {
            PersonaCursoDTO personaCursoDTO = new PersonaCursoDTO();
            personaCursoDTO.setId(item.getId());
            personaCursoDTO.setObservacion(item.getObservacion());
            personaCursoDTO.setPersonaDTO(new PersonaDTO().getPersonaDTO(item.getPersona()));
            personaCursoDTO.setCursoDTO(new CursoDTO().getCursoDTO(item.getCurso()));


            personaCursoDTOList.add(personaCursoDTO);
        }
        return personaCursoDTOList;
    }
}
