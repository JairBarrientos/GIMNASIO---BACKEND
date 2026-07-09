package com.gimnasio.controller;

import com.gimnasio.dto.UsuarioDTO;
import com.gimnasio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listar();
    }

    @GetMapping("{id}")
    public Optional<UsuarioDTO> buscar(@PathVariable int id) {
        return service.getByIdDTO(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UsuarioDTO crear(@RequestBody UsuarioDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("{id}")
    public UsuarioDTO actualizar(@PathVariable int id, @RequestBody UsuarioDTO dto) {
        return service.actualizar(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/por-rol/{nombreRol}")
    public List<UsuarioDTO> listarPorRol(@PathVariable String nombreRol) {
        return service.listarPorRol(nombreRol);
    }

    @GetMapping("/buscar/{texto}")
    public List<UsuarioDTO> buscarPorNombre(@PathVariable String texto) {
        return service.buscarPorNombre(texto);
    }
}