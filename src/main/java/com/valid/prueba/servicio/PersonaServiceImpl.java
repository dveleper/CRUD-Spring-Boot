package com.valid.prueba.servicio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.valid.prueba.dao.IPersonaDao;
import com.valid.prueba.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonaServiceImpl implements IPersonaService {

    private static final String GET_ALL_PERSONAS_API = "http://localhost:8080/listarPersonas";
    private static final String UPDATE_PERSONA_API = "http://localhost:8080/actualizarPersona";
    private static final String CREATE_PERSONA_API = "http://localhost:8080/agregarRest";

    static RestTemplate restTemplate = new RestTemplate();
    
    @Autowired
    private IPersonaDao personaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }

    @Override
    public Persona actualizar(Persona persona) {
        Persona personaOld = null;
        personaOld = personaDao.findById(persona.getIdPersona()).orElse(null);
        if (personaOld != null) {
            personaOld.setNombre(persona.getNombre());
            personaOld.setApellido(persona.getApellido());
            personaOld.setProcesado(persona.isProcesado());
            personaDao.save(personaOld);
        } else {
            return new Persona();
        }
        return personaOld;
    }

    @Override
    public List<Persona> listarPersonasRest() {
        ResponseEntity<Persona[]> response
                = restTemplate.getForEntity(
                        GET_ALL_PERSONAS_API,
                        Persona[].class);
        Persona[] personas = response.getBody();
        
        return Arrays.asList(personas);
    }

    @Override
    public Persona insertarPersonaRest(Persona persona) {
        ResponseEntity<Persona> postForEntity = restTemplate.postForEntity(CREATE_PERSONA_API, persona, Persona.class);
        return postForEntity.getBody();
    }

    @Override
    public Persona actualizarPersonaRest(Persona persona) {
        ResponseEntity<Persona> postForEntity = restTemplate.postForEntity(CREATE_PERSONA_API, persona, Persona.class);
        return postForEntity.getBody();
    }
    
}
