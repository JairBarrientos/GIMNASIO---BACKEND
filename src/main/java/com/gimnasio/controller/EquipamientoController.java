package com.gimnasio.controller;

import com.gimnasio.dto.EquipamientoDTO;
import com.gimnasio.service.EquipamientoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipamiento")
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

    @PostMapping
    public EquipamientoDTO save(@RequestBody EquipamientoDTO dto) {
        return equipamientoService.save(dto);
    }

    @PutMapping("/{id}")
    public EquipamientoDTO update(@PathVariable Integer id, @RequestBody EquipamientoDTO dto) {
        dto.setIdEquipamiento(id);
        return equipamientoService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        equipamientoService.delete(id);
    }
}
