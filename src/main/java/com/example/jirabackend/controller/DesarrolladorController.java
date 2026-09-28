package com.example.jirabackend.controller;

import com.example.jirabackend.Model.Desarrollador;
import com.example.jirabackend.service.DesarrolladorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desarrolladores")
public class DesarrolladorController {

    private final DesarrolladorService service;

    public DesarrolladorController(DesarrolladorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Desarrollador> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desarrollador> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Desarrollador crear(@RequestBody Desarrollador desarrollador) {
        return service.guardar(desarrollador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desarrollador> actualizar(@PathVariable Long id,
                                                    @RequestBody Desarrollador datos) {
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