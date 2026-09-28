package com.example.jirabackend.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HistoriaDeUsuario extends Trabajo {

    private Integer puntosEstimacion;
    private String valorNegocio;

    // Agregación: los criterios tienen vida propia, no se borran con la historia
    @OneToMany
    @JoinColumn(name = "historia_id")
    private List<CriterioDeAceptacion> criterios = new ArrayList<>();

    public HistoriaDeUsuario() {
    }

    public HistoriaDeUsuario(String titulo, String descripcion, Estado estado,
                             Integer puntosEstimacion, String valorNegocio) {
        super(titulo, descripcion, estado);
        this.puntosEstimacion = puntosEstimacion;
        this.valorNegocio = valorNegocio;
    }

    public Integer getPuntosEstimacion() { return puntosEstimacion; }
    public void setPuntosEstimacion(Integer puntosEstimacion) { this.puntosEstimacion = puntosEstimacion; }

    public String getValorNegocio() { return valorNegocio; }
    public void setValorNegocio(String valorNegocio) { this.valorNegocio = valorNegocio; }

    public List<CriterioDeAceptacion> getCriterios() { return criterios; }
    public void setCriterios(List<CriterioDeAceptacion> criterios) { this.criterios = criterios; }
}
