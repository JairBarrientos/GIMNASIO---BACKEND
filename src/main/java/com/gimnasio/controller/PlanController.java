package com.gimnasio.controller;

import com.gimnasio.model.Plan;
import com.gimnasio.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private PlanService service;

    @GetMapping
    public List<Plan> listar() {
        return service.listar();
    }

    @GetMapping("{id}")
    public Optional<Plan> buscar(@PathVariable int id) {
        return service.getId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int crear(@RequestBody Plan p) {
        return service.save(p);
    }

    @PutMapping("{id}")
    public int actualizar(@PathVariable int id, @RequestBody Plan form) {
        Optional<Plan> optional = service.getId(id);
        if (optional.isPresent()) {
            Plan p = optional.get();
            p.setNombre(form.getNombre());
            p.setDescripcion(form.getDescripcion());
            p.setPrecio(form.getPrecio());
            p.setDuracionDias(form.getDuracionDias());
            return service.save(p);
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable int id) {
        service.delete(id);
    }
}