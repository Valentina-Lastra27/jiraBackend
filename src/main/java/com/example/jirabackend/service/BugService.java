package com.example.jirabackend.service;

import com.example.jirabackend.Model.bug;
import com.example.jirabackend.repository.BugRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugService {

    private final BugRepository repository;

    public BugService(BugRepository repository) {
        this.repository = repository;
    }

    public List<bug> listar() {
        return repository.findAll();
    }

    public Optional<bug> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public bug guardar(bug bug) {
        return repository.save(bug);
    }

    public Optional<bug> actualizar(Long id, bug datos) {
        Optional<bug> existente = repository.findById(id);
        if (existente.isEmpty()) {
            return Optional.empty();
        }
        bug b = existente.get();
        b.setTitulo(datos.getTitulo());
        b.setDescripcion(datos.getDescripcion());
        b.setEstado(datos.getEstado());
        b.setResponsable(datos.getResponsable());
        b.setPasosReproduccion(datos.getPasosReproduccion());
        b.setSeveridad(datos.getSeveridad());
        return Optional.of(repository.save(b));
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}