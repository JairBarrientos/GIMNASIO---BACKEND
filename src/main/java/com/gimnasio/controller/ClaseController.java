package com.gimnasio.controller;

import com.gimnasio.model.Clase;
import com.gimnasio.service.ClaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clases")
public class ClaseController {

    private final ClaseService service;

    public ClaseController(ClaseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Clase> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Clase buscar(@PathVariable Long id) {
        return service.getId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Clase crear(@RequestBody Clase clase) {
        return service.save(clase);
    }

    @PutMapping("/{id}")
    public Clase actualizar(@PathVariable Long id, @RequestBody Clase clase) {
        clase.setIdClase(id);
        return service.save(clase);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }
}