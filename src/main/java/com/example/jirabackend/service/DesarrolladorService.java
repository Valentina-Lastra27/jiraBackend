package com.example.jirabackend.service;

import com.example.jirabackend.Model.Desarrollador;
import com.example.jirabackend.repository.DesarrolladorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesarrolladorService {

    private final DesarrolladorRepository repository;

    public DesarrolladorService(DesarrolladorRepository repository) {
        this.repository = repository;
    }

    public List<Desarrollador> listar() {
        return repository.findAll();
    }

    public Optional<Desarrollador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Desarrollador guardar(Desarrollador desarrollador) {
        return repository.save(desarrollador);
    }

    public Optional<Desarrollador> actualizar(Long id, Desarrollador datos) {
        Optional<Desarrollador> existente = repository.findById(id);
        if (existente.isEmpty()) {
            return Optional.empty();
        }
        Desarrollador d = existente.get();
        d.setNombre(datos.getNombre());
        d.setEspecialidad(datos.getEspecialidad());
        d.setMail(datos.getMail());
        return Optional.of(repository.save(d));
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}