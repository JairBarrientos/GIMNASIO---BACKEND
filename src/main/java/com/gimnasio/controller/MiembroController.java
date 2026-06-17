package com.gimnasio.controller;

import com.gimnasio.dto.MiembroDTO;
import com.gimnasio.model.Miembro;
import com.gimnasio.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/miembros")
public class MiembroController {

    @Autowired
    private MiembroService service;

    @GetMapping
    public List<MiembroDTO> listar() {
        return service.listarDTO();
    }

    @GetMapping("{id}")
    public Optional<MiembroDTO> buscar(@PathVariable int id) {
        return service.getId(id).map(service::convertirDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int crear(@RequestBody Miembro m) {
        return service.save(m);
    }

    @PutMapping("{id}")
    public int actualizar(@PathVariable int id, @RequestBody Miembro form) {
        Optional<Miembro> optional = service.getId(id);
        if (optional.isPresent()) {
            Miembro m = optional.get();
            m.setFechaInicio(form.getFechaInicio());
            m.setFechaFin(form.getFechaFin());
            m.setEstado(form.getEstado());
            m.setUsuario(form.getUsuario());
            m.setPlan(form.getPlan());
            return service.save(m);
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/por-plan/{nombrePlan}")
    public List<MiembroDTO> listarPorPlan(@PathVariable String nombrePlan) {
        return service.listarPorPlan(nombrePlan);
    }
}