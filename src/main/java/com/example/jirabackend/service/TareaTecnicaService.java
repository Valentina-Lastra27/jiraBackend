package com.example.jirabackend.service;

import com.example.jirabackend.Model.TareaTecnica;
import com.example.jirabackend.repository.TareaTecnicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaTecnicaService {

    private final TareaTecnicaRepository repository;

    public TareaTecnicaService(TareaTecnicaRepository repository) {
        this.repository = repository;
    }

    public List<TareaTecnica> listar() {
        return repository.findAll();
    }

    public Optional<TareaTecnica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public TareaTecnica guardar(TareaTecnica tarea) {
        return repository.save(tarea);
    }

    public Optional<TareaTecnica> actualizar(Long id, TareaTecnica datos) {
        Optional<TareaTecnica> existente = repository.findById(id);
        if (existente.isEmpty()) {
            return Optional.empty();
        }
        TareaTecnica t = existente.get();
        t.setTitulo(datos.getTitulo());
        t.setDescripcion(datos.getDescripcion());
        t.setEstado(datos.getEstado());
        t.setResponsable(datos.getResponsable());
        t.setTareaTecnica(datos.getTareaTecnica());
        t.setComponenteAfectado(datos.getComponenteAfectado());
        return Optional.of(repository.save(t));
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}