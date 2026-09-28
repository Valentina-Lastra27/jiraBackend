package com.example.jirabackend.controller;

import com.example.jirabackend.Model.CriterioDeAceptacion;
import com.example.jirabackend.service.CriterioDeAceptacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criterios")
public class CriterioDeAceptacionController {

    private final CriterioDeAceptacionService service;

    public CriterioDeAceptacionController(CriterioDeAceptacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<CriterioDeAceptacion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriterioDeAceptacion> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CriterioDeAceptacion crear(@RequestBody CriterioDeAceptacion criterio) {
        return service.guardar(criterio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriterioDeAceptacion> actualizar(@PathVariable Long id,
                                                           @RequestBody CriterioDeAceptacion datos) {
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
