package com.gimnasio.controller;

import com.gimnasio.dto.PlanDTO;
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
    public List<PlanDTO> listar() {
        return service.listar();
    }

    @GetMapping("{id}")
    public Optional<PlanDTO> buscar(@PathVariable int id) {
        return service.getByIdDTO(id);
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

    @GetMapping("/buscar")
    public List<PlanDTO> buscarPorNombre(@RequestParam String texto) {
        return service.buscarPorNombre(texto);
    }

    @GetMapping("/precio-maximo")
    public List<PlanDTO> buscarPorPrecioMaximo(@RequestParam Double precio) {
        return service.buscarPorPrecioMaximo(precio);
    }

    @GetMapping("/con-miembros")
    public List<PlanDTO> buscarConMiembros(@RequestParam(defaultValue = "ACTIVO") String estado) {
        return service.buscarConMiembrosEnEstado(estado);
    }

    @GetMapping("/duracion-minima")
    public List<Plan> buscarPorDuracion(@RequestParam Integer dias) {
        return service.buscarPorDuracionMinimaNative(dias);
    }
    
    @GetMapping("/con-miembros-native")
    public List<PlanDTO> buscarConMiembrosNative(@RequestParam(defaultValue = "ACTIVO") String estado) {
        return service.buscarConMiembrosEnEstadoNative(estado);
    }
}