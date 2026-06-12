package com.gimnasio.controller;

import com.gimnasio.dto.MantenimientoDTO;
import com.gimnasio.service.MantenimientoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    @GetMapping
    public List<MantenimientoDTO> listar() {
        return mantenimientoService.listar();
    }

    @GetMapping("/{id}")
    public MantenimientoDTO getId(@PathVariable Integer id) {
        return mantenimientoService.getId(id);
    }

    @PostMapping
    public MantenimientoDTO save(@RequestBody MantenimientoDTO dto) {
        return mantenimientoService.save(dto);
    }

    @PutMapping("/{id}")
    public MantenimientoDTO update(@PathVariable Integer id, @RequestBody MantenimientoDTO dto) {
        dto.setIdMantenimiento(id);
        return mantenimientoService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        mantenimientoService.delete(id);
    }

    @GetMapping("/filtrarPorArea/{area}")
    public List<MantenimientoDTO> buscarPorArea(@PathVariable String area) {
        return mantenimientoService.consultaMultitabla(area);
    }
}
