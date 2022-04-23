package com.valid.prueba.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import com.valid.prueba.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.valid.prueba.servicio.IPersonaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        List personas = (List) personaService.listarPersonasRest();
        model.addAttribute("personas", personas);
    
        return "index";
    }
    
    @GetMapping("/registro")
    public String registrar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona, Model model){
        personaService.eliminar(persona);
        model.addAttribute("persona", persona);
        return "redirect:/";
    }
    
    @GetMapping("/procesar/{idPersona}")
    public String procesar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        persona.setProcesado(true);
        System.out.println("persona antes de guardar: " + persona);
        personaService.guardar(persona);
        model.addAttribute("persona", persona);
        return "redirect:/";
    }
}