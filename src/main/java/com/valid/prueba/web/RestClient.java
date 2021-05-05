package com.valid.prueba.web;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.valid.prueba.domain.Persona;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestClient {

    private static final String GET_ALL_PERSONAS_API = "http://localhost:8080/listarPersonas";
    private static final String UPDATE_PERSONA_API = "http://localhost:8080/actualizarPersona";
    private static final String CREATE_PERSONA_API = "http://localhost:8080/agregarRest";

    static RestTemplate restTemplate = new RestTemplate();

    public Persona[] listarPersonasRest() {
        ResponseEntity<Persona[]> response
                = restTemplate.getForEntity(
                        GET_ALL_PERSONAS_API,
                        Persona[].class);
        Persona[] personas = response.getBody();
        
        return personas;
    }

    

}
