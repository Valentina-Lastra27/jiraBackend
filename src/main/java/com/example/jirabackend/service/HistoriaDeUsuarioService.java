package com.example.jirabackend.service;

import com.example.jirabackend.Model.HistoriaDeUsuario;
import com.example.jirabackend.repository.HistoriaDeUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriaDeUsuarioService {

    private final HistoriaDeUsuarioRepository repository;

    public HistoriaDeUsuarioService(HistoriaDeUsuarioRepository repository) {
        this.repository = repository;
    }

    public List<HistoriaDeUsuario> listar() {
        return repository.findAll();
    }

    public Optional<HistoriaDeUsuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public HistoriaDeUsuario guardar(HistoriaDeUsuario historia) {
        return repository.save(historia);
    }

    public Optional<HistoriaDeUsuario> actualizar(Long id, HistoriaDeUsuario datos) {
        Optional<HistoriaDeUsuario> existente = repository.findById(id);
        if (existente.isEmpty()) {
            return Optional.empty();
        }
        HistoriaDeUsuario h = existente.get();
        h.setTitulo(datos.getTitulo());
        h.setDescripcion(datos.getDescripcion());
        h.setEstado(datos.getEstado());
        h.setResponsable(datos.getResponsable());
        h.setPuntosEstimacion(datos.getPuntosEstimacion());
        h.setValorNegocio(datos.getValorNegocio());
        h.setCriterios(datos.getCriterios());
        return Optional.of(repository.save(h));
    }

    public boolean eliminar(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}