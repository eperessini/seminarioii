package com.undec.gedufy.service;

import com.undec.gedufy.dto.Response;
import com.undec.gedufy.model.TipoPersona;
import com.undec.gedufy.repository.TipoPersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author etorrielli
 */
@Service
public class TipoPersonaService {

    static final Logger LOGGER = LoggerFactory.getLogger(TipoPersonaService.class);

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    public Response findAll() {
        Response response = new Response();
        try {
            List<TipoPersona> tipoPersonaList = tipoPersonaRepository.findAll();
            response.setData(tipoPersonaList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findOneById(String id) {
        Response response = new Response();
        try {
            TipoPersona tipoPersona = tipoPersonaRepository.findById(Integer.parseInt(id)).get();
            response.setData(tipoPersona);

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(Object input) {
        Response response = new Response();
        try {

            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(TipoPersona tipoPersona) {
        Response response = new Response();
        try {
            tipoPersona = tipoPersonaRepository.save(tipoPersona);

            response.setData(tipoPersona);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response delete(String id) {
        Response response = new Response();
        try {
            TipoPersona tipoPersona = tipoPersonaRepository.findById(Integer.parseInt(id)).get();
            tipoPersonaRepository.save(tipoPersona);

            response.setMessage("Eliminado correctamente.");

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;
    }

}