package com.undec.gedufy.dto;

import com.undec.gedufy.model.Persona;
import com.undec.gedufy.model.TipoPersona;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonaDTO {
    private Integer id;
    private String nombre;
    private String dni;
    private String fechaNacimiento;
    private String celular;
    private String email;
    private String direccion;
    private TipoPersonaDTO tipoPersonaDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoPersonaDTO getTipoPersonaDTO() {
        return tipoPersonaDTO;
    }

    public void setTipoPersonaDTO(TipoPersonaDTO tipoPersonaDTO) {
        this.tipoPersonaDTO = tipoPersonaDTO;
    }

    public PersonaDTO getPersonaDTO(Persona persona) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);

        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setDni(persona.getDni());
        personaDTO.setFechaNacimiento((persona.getFechaNacimiento() != null) ? df.format(persona.getFechaNacimiento()) : null);
        personaDTO.setCelular(persona.getCelular());
        personaDTO.setEmail(persona.getEmail());
        personaDTO.setDireccion(persona.getDireccion());

        TipoPersonaDTO tipoPersonaDTO = new TipoPersonaDTO();
        tipoPersonaDTO.setId(persona.getTipoPersona().getId());
        tipoPersonaDTO.setNombre(persona.getTipoPersona().getNombre());
        personaDTO.setTipoPersonaDTO(tipoPersonaDTO);

        return personaDTO;
    }

    public List<PersonaDTO> getPersonaDTOList(List<Persona> personaList) {
        List<PersonaDTO> personaDTOList = new ArrayList<>();
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);

        for (Persona item : personaList) {
            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setId(item.getId());
            personaDTO.setNombre(item.getNombre());
            personaDTO.setDni(item.getDni());
            personaDTO.setFechaNacimiento((item.getFechaNacimiento() != null) ? df.format(item.getFechaNacimiento()) : null);
            personaDTO.setCelular(item.getCelular());
            personaDTO.setEmail(item.getEmail());
            personaDTO.setDireccion(item.getDireccion());

            TipoPersonaDTO tipoPersonaDTO = new TipoPersonaDTO();
            tipoPersonaDTO.setId(item.getTipoPersona().getId());
            tipoPersonaDTO.setNombre(item.getTipoPersona().getNombre());
            personaDTO.setTipoPersonaDTO(tipoPersonaDTO);

            personaDTOList.add(personaDTO);
        }
        return personaDTOList;
    }

    public Persona getPersona(PersonaDTO personaDTO, TipoPersona tipoPersona) throws Exception {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);

        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setDni(personaDTO.getDni());
        persona.setFechaNacimiento((personaDTO.getFechaNacimiento() != null) ? df.parse(personaDTO.getFechaNacimiento()) : null);
        persona.setCelular(personaDTO.getCelular());
        persona.setEmail(personaDTO.getEmail());
        persona.setDireccion(personaDTO.getDireccion());
        persona.setTipoPersona(tipoPersona);
        persona.setCreatedBy("anonimo");
        persona.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        persona.setUpdatedBy("anonimo");
        persona.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return persona;
    }
}
