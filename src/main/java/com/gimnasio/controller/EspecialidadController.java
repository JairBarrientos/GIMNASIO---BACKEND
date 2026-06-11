package com.gimnasio.controller;

import com.gimnasio.dto.EspecialidadDTO;
import com.gimnasio.model.Especialidad;
import com.gimnasio.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @GetMapping
    public List<Especialidad> listar() {
        return service.listar();
    }

    @GetMapping("/dto")
    public List<EspecialidadDTO> listarDTO() {
        return service.listarDTO();
    }

    @GetMapping("{id}")
    public Optional<Especialidad> buscar(@PathVariable int id) {
        return service.getId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int crear(@RequestBody Especialidad e) {
        return service.save(e);
    }

    @PutMapping("{id}")
    public int actualizar(@PathVariable int id, @RequestBody Especialidad form) {
        Optional<Especialidad> optional = service.getId(id);
        if (optional.isPresent()) {
            Especialidad e = optional.get();
            e.setNombre(form.getNombre());
            e.setDescripcion(form.getDescripcion());
            e.setEstado(form.getEstado());
            return service.save(e);
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable int id) {
        service.delete(id);
    }
}