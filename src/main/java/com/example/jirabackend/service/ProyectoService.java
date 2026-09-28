package com.example.jirabackend.service;

import com.example.jirabackend.Model.Proyecto;
import com.example.jirabackend.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository repository;

    public ProyectoService(ProyectoRepository repository) {
        this.repository = repository;
    }

    public List<Proyecto> listar() {
        return repository.findAll();
    }

    public Optional<Proyecto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Proyecto guardar(Proyecto proyecto) {
        return repository.save(proyecto);
    }

    public Optional<Proyecto> actualizar(Long id, Proyecto datos) {
        Optional<Proyecto> existente = repository.findById(id);
        if (existente.isEmpty()) {
            return Optional.empty();
        }
        Proyecto p = existente.get();
        p.setNombre(datos.getNombre());
        p.setClave(datos.getClave());
        p.setDesarrolladores(datos.getDesarrolladores());
        return Optional.of(repository.save(p));
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}