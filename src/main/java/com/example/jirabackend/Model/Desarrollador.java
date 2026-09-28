package com.example.jirabackend.Model;

import jakarta.persistence.*;

@Entity
public class Desarrollador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String mail;

    public Desarrollador() {
    }

    public Desarrollador(String nombre, String especialidad, String mail) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.mail = mail;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
}
