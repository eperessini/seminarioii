package com.undec.gedufy.service;

import com.undec.gedufy.dto.PersonaDTO;
import com.undec.gedufy.dto.Response;
import com.undec.gedufy.model.Persona;
import com.undec.gedufy.model.PersonaCurso;
import com.undec.gedufy.model.TipoPersona;
import com.undec.gedufy.repository.PersonaRepository;
import com.undec.gedufy.repository.TipoPersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author etorrielli
 */
@Service
public class PersonaService {

    static final Logger LOGGER = LoggerFactory.getLogger(PersonaService.class);
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    public Response findAll() {
        Response response = new Response();
        try {
            List<PersonaDTO> personaDTOList = new PersonaDTO().getPersonaDTOList(personaRepository.findAll());
            response.setData(personaDTOList);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findOneById(String id) {
        Response response = new Response();
        try {
            PersonaDTO personaDTO = new PersonaDTO().getPersonaDTO(personaRepository.findById(Integer.parseInt(id)).get());
            response.setData(personaDTO);

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(PersonaDTO input) throws Exception {
        Response response = new Response();
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            Persona persona = personaRepository.findById(input.getId()).get();
            if (input.getDireccion() != null)
                persona.setDireccion(input.getDireccion());
            if (input.getCelular() != null)
                persona.setCelular(input.getCelular());
            if (input.getDni() != null)
                persona.setDni(input.getDni());
            if (input.getEmail() != null)
                persona.setEmail(input.getEmail());
            if (input.getNombre() != null)
                persona.setNombre(input.getNombre());
            if (input.getFechaNacimiento() != null)
                persona.setFechaNacimiento(df.parse(input.getFechaNacimiento()));
            persona.setUpdatedBy("anonimo");
            persona.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            personaRepository.save(persona);

            response.setData(persona);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(PersonaDTO input) throws Exception {
        Response response = new Response();
        try {
            TipoPersona tipoPersona = tipoPersonaRepository.findById(input.getTipoPersonaDTO().getId()).get();
            Persona persona = new PersonaDTO().getPersona(input, tipoPersona);
            persona = personaRepository.save(persona);

            response.setData(persona);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(String id) {
        Response response = new Response();
        try {
            Persona persona = personaRepository.findById(Integer.parseInt(id)).get();
            persona.setDeletedBy("anonimo");
            persona.setDeletedAt(new Timestamp(System.currentTimeMillis()));
            personaRepository.save(persona);

            response.setMessage("Eliminado correctamente.");

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;
    }

    public Response findByName(String nombre) {
        Response response = new Response();
        try {
            List<Persona> personaList = personaRepository.findAllByNombreContaining(nombre);
            response.setData(personaList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

}