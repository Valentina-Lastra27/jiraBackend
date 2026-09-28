package com.example.jirabackend.Model;

import jakarta.persistence.Entity;

@Entity
public class TareaTecnica extends Trabajo {

    private String tareaTecnica;
    private String componenteAfectado;

    public TareaTecnica() {
    }

    public TareaTecnica(String titulo, String descripcion, Estado estado,
                        String tareaTecnica, String componenteAfectado) {
        super(titulo, descripcion, estado);
        this.tareaTecnica = tareaTecnica;
        this.componenteAfectado = componenteAfectado;
    }

    public String getTareaTecnica() { return tareaTecnica; }
    public void setTareaTecnica(String tareaTecnica) { this.tareaTecnica = tareaTecnica; }

    public String getComponenteAfectado() { return componenteAfectado; }
    public void setComponenteAfectado(String componenteAfectado) { this.componenteAfectado = componenteAfectado; }
}