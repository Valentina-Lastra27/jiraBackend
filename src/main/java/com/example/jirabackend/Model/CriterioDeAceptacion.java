package com.example.jirabackend.Model;

import jakarta.persistence.*;

@Entity
public class CriterioDeAceptacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Boolean cumplido;

    public CriterioDeAceptacion() {
    }

    public CriterioDeAceptacion(String descripcion, Boolean cumplido) {
        this.descripcion = descripcion;
        this.cumplido = cumplido;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Boolean getCumplido() { return cumplido; }
    public void setCumplido(Boolean cumplido) { this.cumplido = cumplido; }
}