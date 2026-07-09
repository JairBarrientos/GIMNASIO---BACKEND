package com.gimnasio.controller;

import com.gimnasio.dto.MiembroDTO;
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
    public MiembroDTO crear(@RequestBody MiembroDTO dto) {
        return service.save(dto);
    }

    @PutMapping("{id}")
    public MiembroDTO actualizar(@PathVariable int id, @RequestBody MiembroDTO dto) {
        dto.setIdMiembro(id);
        return service.save(dto);
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

    @GetMapping("/buscar")
    public List<MiembroDTO> buscarPorNombreUsuario(@RequestParam String texto) {
        return service.buscarPorNombreUsuario(texto);
    }

    @GetMapping("/por-plan-native/{nombrePlan}")
    public List<MiembroDTO> buscarPorPlanNative(@PathVariable String nombrePlan) {
        return service.buscarPorPlanNative(nombrePlan);
    }
}