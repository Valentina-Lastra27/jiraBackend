package com.example.jirabackend.Model;

import jakarta.persistence.Entity;

@Entity
public class bug extends Trabajo {

    private String pasosReproduccion;
    private String severidad;

    public bug() {
    }

    public bug(String titulo, String descripcion, Estado estado,
               String pasosReproduccion, String severidad) {
        super(titulo, descripcion, estado);
        this.pasosReproduccion = pasosReproduccion;
        this.severidad = severidad;
    }

    public String getPasosReproduccion() { return pasosReproduccion; }
    public void setPasosReproduccion(String pasosReproduccion) { this.pasosReproduccion = pasosReproduccion; }

    public String getSeveridad() { return severidad; }
    public void setSeveridad(String severidad) { this.severidad = severidad; }
}