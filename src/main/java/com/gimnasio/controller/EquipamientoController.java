package com.gimnasio.controller;

import com.gimnasio.dto.EquipamientoDTO;
import com.gimnasio.model.Equipamiento;
import com.gimnasio.service.EquipamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/equipamiento")
public class EquipamientoController {

    private final EquipamientoService equipamientoService;

    public EquipamientoController(EquipamientoService equipamientoService) {
        this.equipamientoService = equipamientoService;
    }

    @GetMapping
    public List<EquipamientoDTO> listar() {
        return equipamientoService.listar();
    }

    @GetMapping("/{id}")
    public EquipamientoDTO getId(@PathVariable Integer id) {
        return equipamientoService.getId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EquipamientoDTO save(@RequestBody EquipamientoDTO dto) {
        return equipamientoService.save(dto);
    }

    @PutMapping("/{id}")
    public EquipamientoDTO update(@PathVariable Integer id, @RequestBody EquipamientoDTO dto) {
        dto.setIdEquipamiento(id);
        return equipamientoService.save(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        equipamientoService.delete(id);
    }

    @GetMapping("/buscar-area")
    public List<EquipamientoDTO> buscarPorArea(@RequestParam String area) {
        return equipamientoService.buscarPorArea(area);
    }

    @GetMapping("/estado/{estado}")
    public List<EquipamientoDTO> buscarPorEstado(@PathVariable String estado) {
        return equipamientoService.buscarPorEstado(estado);
    }

    @GetMapping("/con-mantenimiento")
    public List<Equipamiento> conMantenimiento() {
        return equipamientoService.equipamientoConMantenimiento();
    }
}