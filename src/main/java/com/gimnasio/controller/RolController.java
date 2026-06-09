package com.gimnasio.controller;

import com.gimnasio.model.Rol;
import com.gimnasio.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    public List<Rol> listar() {
        return service.listar();
    }

    @GetMapping("{id}")
    public Optional<Rol> buscar(@PathVariable int id) {
        return service.getId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int crear(@RequestBody Rol r) {
        return service.save(r);
    }

    @PutMapping("{id}")
    public int actualizar(@PathVariable int id, @RequestBody Rol form) {
        Optional<Rol> optional = service.getId(id);
        if (optional.isPresent()) {
            Rol rol = optional.get();
            rol.setNombre(form.getNombre());
            rol.setDescripcion(form.getDescripcion());
            return service.save(rol);
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable int id) {
        service.delete(id);
    }
}