package com.valid.prueba.servicio;

import java.util.List;
import com.valid.prueba.domain.Persona;

public interface IPersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    
    public Persona actualizar(Persona persona);
    
    public List<Persona> listarPersonasRest();
    
    public Persona insertarPersonaRest(Persona persona);
    
    public Persona actualizarPersonaRest(Persona persona);
}
