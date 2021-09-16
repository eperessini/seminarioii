package com.undec.gedufy.service;

import com.undec.gedufy.dto.Response;
import com.undec.gedufy.model.Curso;
import com.undec.gedufy.repository.CursoRepository;
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
public class CursoService {

    static final Logger LOGGER = LoggerFactory.getLogger(CursoService.class);

    @Autowired
    private CursoRepository cursoRepository;

    public Response findAll() {
        Response response = new Response();
        try {
            List<Curso> cursoList = cursoRepository.findAll();
            response.setData(cursoList);
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
            Curso curso = cursoRepository.findById(Integer.parseInt(id)).get();
            response.setData(curso);

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
            throw e;
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

    public Response save(Curso curso) {
        Response response = new Response();
        try {
            curso = cursoRepository.save(curso);

            response.setData(curso);

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
            Curso curso = cursoRepository.findById(Integer.parseInt(id)).get();
            // setear campos
            cursoRepository.save(curso);

            response.setMessage("Eliminado correctamente.");

        } catch (NoSuchElementException e) {
            LOGGER.error("No existe.");
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error general.");
            throw e;
        }
        return response;
    }

}