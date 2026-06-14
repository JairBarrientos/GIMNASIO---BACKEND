package com.gimnasio.controller;

import com.gimnasio.dto.UsuarioDTO;
import com.gimnasio.model.Usuario;
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
    public int crear(@RequestBody Usuario u) {
        return service.save(u);
    }

    @PutMapping("{id}")
    public int actualizar(@PathVariable int id, @RequestBody Usuario form) {
        Optional<Usuario> optional = service.getId(id);
        if (optional.isPresent()) {
            Usuario u = optional.get();
            u.setNombres(form.getNombres());
            u.setApellidos(form.getApellidos());
            u.setCorreo(form.getCorreo());
            u.setPassword(form.getPassword());
            u.setTelefono(form.getTelefono());
            u.setEstado(form.getEstado());
            u.setRol(form.getRol());
            return service.save(u);
        }
        return 0;
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