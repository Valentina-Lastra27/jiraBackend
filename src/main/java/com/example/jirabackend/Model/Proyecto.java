package com.example.jirabackend.Model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String clave;

    @ManyToMany
    @JoinTable(
            name = "proyecto_desarrollador",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "desarrollador_id")
    )
    private Set<Desarrollador> desarrolladores = new HashSet<>();

    public Proyecto() {
    }

    public Proyecto(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public Set<Desarrollador> getDesarrolladores() { return desarrolladores; }
    public void setDesarrolladores(Set<Desarrollador> desarrolladores) { this.desarrolladores = desarrolladores; }
}