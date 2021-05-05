package com.valid.prueba.web;

import java.util.List;
import java.util.Optional;
import com.valid.prueba.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import com.valid.prueba.servicio.IPersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControladorRest {
    
    @Autowired
    private IPersonaService personaService;
    
    @PostMapping("/agregarRest")
    public Persona agregarRest(@RequestBody Persona persona){
        personaService.guardar(persona);
        return persona;
    }
    
    @GetMapping("/listarPersonas")
    public  List<Persona> listarPersonas(){
        return personaService.listarPersonas();
    }
    
    @PutMapping("/actualizarPersona")
    public Persona actualizarPersona(@RequestBody Persona persona){
        return personaService.actualizar(persona);
    }
    
}