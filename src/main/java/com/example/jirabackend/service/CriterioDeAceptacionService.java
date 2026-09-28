package com.example.jirabackend.service;

import com.example.jirabackend.Model.CriterioDeAceptacion;
import com.example.jirabackend.repository.CriterioDeAceptacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriterioDeAceptacionService {

    private final CriterioDeAceptacionRepository repository;

    public CriterioDeAceptacionService(CriterioDeAceptacionRepository repository) {
        this.repository = repository;
    }

    public List<CriterioDeAceptacion> listar() {
        return repository.findAll();
    }

    public Optional<CriterioDeAceptacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public CriterioDeAceptacion guardar(CriterioDeAceptacion criterio) {
        return repository.save(criterio);
    }

    public Optional<CriterioDeAceptacion> actualizar(Long id, CriterioDeAceptacion datos) {
        Optional<CriterioDeAceptacion> existente = repository.findById(id);
        if (existente.isEmpty()) {
            return Optional.empty();
        }
        CriterioDeAceptacion c = existente.get();
        c.setDescripcion(datos.getDescripcion());
        c.setCumplido(datos.getCumplido());
        return Optional.of(repository.save(c));
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}