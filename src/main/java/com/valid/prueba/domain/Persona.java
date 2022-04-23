package com.valid.prueba.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Id
    @GeneratedValue
    private int idPersona;
    private String nombre;
    private String apellido;
    private boolean procesado;
}
