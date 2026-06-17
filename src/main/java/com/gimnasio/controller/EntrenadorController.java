package com.gimnasio.controller;

import com.gimnasio.dto.EntrenadorDTO;
import com.gimnasio.model.Entrenador;
import com.gimnasio.model.Especialidad;
import com.gimnasio.model.Usuario;
import com.gimnasio.service.EntrenadorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService service;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public List<Entrenador> listar() {
        return service.listar();
    }

    @GetMapping("/dto")
    public List<EntrenadorDTO> listarDTO() {
        return service.listarDTO();
    }

    @GetMapping("{id}")
    public Optional<EntrenadorDTO> buscar(@PathVariable int id) {
        return service.getId(id).map(service::convertirDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int crear(@RequestBody Entrenador e,
                      @RequestParam Integer idUsuario,
                      @RequestParam Integer idEspecialidad) {
        Usuario usuario = entityManager.getReference(Usuario.class, idUsuario);
        Especialidad especialidad = entityManager.getReference(Especialidad.class, idEspecialidad);
        e.setUsuario(usuario);
        e.setEspecialidad(especialidad);
        return service.save(e);
    }

    @PutMapping("{id}")
    public int actualizar(@PathVariable int id, @RequestBody Entrenador form) {
        Optional<Entrenador> optional = service.getId(id);
        if (optional.isPresent()) {
            Entrenador e = optional.get();
            e.setEstado(form.getEstado());

            if (form.getUsuario() != null && form.getUsuario().getIdUsuario() != null) {
                Usuario usuario = entityManager.getReference(Usuario.class, form.getUsuario().getIdUsuario());
                e.setUsuario(usuario);
            }

            if (form.getEspecialidad() != null && form.getEspecialidad().getIdEspecialidad() != null) {
                Especialidad especialidad = entityManager.getReference(Especialidad.class, form.getEspecialidad().getIdEspecialidad());
                e.setEspecialidad(especialidad);
            }

            return service.save(e);
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable int id) {
        service.delete(id);
    }
    
    @GetMapping("/especialidad/{nombre}")
    public List<EntrenadorDTO> buscarPorEspecialidad(@PathVariable String nombre) {
        return service.buscarPorEspecialidadDTO(nombre);
    }

    @GetMapping("/estado/{estado}")
    public List<EntrenadorDTO> buscarPorEstado(@PathVariable String estado) {
        return service.buscarPorEstadoDTO(estado);
    }

    @GetMapping("/buscar")
    public List<EntrenadorDTO> buscarPorNombreUsuario(@RequestParam String texto) {
        return service.buscarPorNombreUsuarioDTO(texto);
    }

    @GetMapping("/especialidad-like-native")
    public List<EntrenadorDTO> buscarPorEspecialidadLikeNative(@RequestParam String nombre) {
        return service.buscarPorEspecialidadLikeNativeDTO(nombre);
    }
}