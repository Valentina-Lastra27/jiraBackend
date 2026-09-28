package com.example.jirabackend.controller;

import com.example.jirabackend.Model.bug;
import com.example.jirabackend.service.BugService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

    private final BugService service;

    public BugController(BugService service) {
        this.service = service;
    }

    @GetMapping
    public List<bug> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<bug> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public bug crear(@RequestBody bug bug) {
        return service.guardar(bug);
    }

    @PutMapping("/{id}")
    public ResponseEntity<bug> actualizar(@PathVariable Long id, @RequestBody bug datos) {
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