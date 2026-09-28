package com.example.jirabackend.controller;

import com.example.jirabackend.Model.TareaTecnica;
import com.example.jirabackend.service.TareaTecnicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas-tecnicas")
public class TareaTecnicaController {

    private final TareaTecnicaService service;

    public TareaTecnicaController(TareaTecnicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TareaTecnica> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaTecnica> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TareaTecnica crear(@RequestBody TareaTecnica tarea) {
        return service.guardar(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaTecnica> actualizar(@PathVariable Long id,
                                                   @RequestBody TareaTecnica datos) {
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