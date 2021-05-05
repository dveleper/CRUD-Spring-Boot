package com.valid.prueba.dao;

import com.valid.prueba.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Integer>{
    
}
