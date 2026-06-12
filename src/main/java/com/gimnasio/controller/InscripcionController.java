package com.gimnasio.controller;

import com.gimnasio.dto.InscripcionDTO;
import com.gimnasio.model.Inscripcion;
import com.gimnasio.service.InscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Inscripcion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Inscripcion buscar(@PathVariable Long id) {
        return service.getId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Inscripcion crear(@RequestBody Inscripcion inscripcion) {
        return service.save(inscripcion);
    }

    @PutMapping("/{id}")
    public Inscripcion actualizar(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        inscripcion.setIdInscripcion(id);
        return service.save(inscripcion);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/dto")
    public List<InscripcionDTO> listarDTO() {
        return service.consultaMultitabla();
    }
}