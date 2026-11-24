package com.ebano.controller;

import com.ebano.model.Proyecto;
import com.ebano.repository.ProyectoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Seccion "Proyectos" (trabajos para clientes). Va en un controlador propio
 * para no tocar PublicController ni AdminController.
 *   Publico: GET /api/public/proyectos (solo los visibles, ordenados)
 *   Panel:   GET/POST /api/admin/proyectos, PUT/DELETE /api/admin/proyectos/{id}
 */
@RestController
@RequestMapping("/api")
public class ProyectoController {

    private final ProyectoRepository proyectoRepository;

    public ProyectoController(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @GetMapping("/public/proyectos")
    public List<Proyecto> publicos() {
        return proyectoRepository.findByVisibleTrueOrderByOrdenAscIdAsc();
    }

    @GetMapping("/admin/proyectos")
    public List<Proyecto> listar() {
        return proyectoRepository.findAllByOrderByOrdenAscIdAsc();
    }

    @PostMapping("/admin/proyectos")
    public Proyecto crear(@Valid @RequestBody Proyecto p) {
        p.setId(null);
        return proyectoRepository.save(p);
    }

    @PutMapping("/admin/proyectos/{id}")
    public ResponseEntity<Proyecto> editar(@PathVariable Long id, @Valid @RequestBody Proyecto p) {
        if (!proyectoRepository.existsById(id)) return ResponseEntity.notFound().build();
        p.setId(id);
        return ResponseEntity.ok(proyectoRepository.save(p));
    }

    @DeleteMapping("/admin/proyectos/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!proyectoRepository.existsById(id)) return ResponseEntity.notFound().build();
        proyectoRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("ok", true));
    }
}
