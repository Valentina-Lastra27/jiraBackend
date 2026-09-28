package com.example.jirabackend.controller;

import com.example.jirabackend.Model.HistoriaDeUsuario;
import com.example.jirabackend.service.HistoriaDeUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historias")
public class HistoriaDeUsuarioController {

    private final HistoriaDeUsuarioService service;

    public HistoriaDeUsuarioController(HistoriaDeUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistoriaDeUsuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaDeUsuario> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HistoriaDeUsuario crear(@RequestBody HistoriaDeUsuario historia) {
        return service.guardar(historia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaDeUsuario> actualizar(@PathVariable Long id,
                                                        @RequestBody HistoriaDeUsuario datos) {
        return service.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}