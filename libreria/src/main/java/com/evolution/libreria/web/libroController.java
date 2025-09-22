package com.evolution.libreria.web;

import com.evolution.libreria.model.libro;
import com.evolution.libreria.repo.libroRepository;
import com.evolution.libreria.web.dto.libroRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin
public class libroController {

    private final libroRepository repo;

    public libroController(libroRepository repo) {
        this.repo = repo;
    }

    // ========== GET ==========
    // Lista todos
    @GetMapping
    public List<libro> listar() {
        return repo.findAll();
    }

    // Por id
    @GetMapping("/{id}")
    public libro obtener(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));
    }

    // ========== POST ==========
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public libro crear(@RequestBody @Valid libroRequest body) {

        libro l = new libro();
        l.setTitulo(body.getTitulo());
        l.setAutorId(body.getAutorId());
        l.setCategoria(body.getCategoria());
        l.setCantidadDisponible(body.getCantidadDisponible());
        return repo.save(l);
    }

    // ========== PUT ==========
    @PutMapping("/{id}")
    public libro actualizar(@PathVariable Integer id, @RequestBody @Valid libroRequest body) {
        libro existente = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado"));

        existente.setTitulo(body.getTitulo());
        existente.setAutorId(body.getAutorId());
        existente.setCategoria(body.getCategoria());
        existente.setCantidadDisponible(body.getCantidadDisponible());

        return repo.save(existente);
    }

    // ========== DELETE ==========
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro no encontrado");
        }
        repo.deleteById(id);
    }
}
