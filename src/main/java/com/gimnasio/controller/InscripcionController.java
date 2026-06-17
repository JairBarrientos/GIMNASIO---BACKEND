package com.gimnasio.controller;

import com.gimnasio.dto.InscripcionDTO;
import com.gimnasio.model.Clase;
import com.gimnasio.model.Inscripcion;
import com.gimnasio.service.InscripcionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }

    @GetMapping
    public List<InscripcionDTO> listar() {
        return service.listarDTO();
    }

    @GetMapping("/{id}")
    public InscripcionDTO buscar(@PathVariable Long id) {
        return service.getByIdDTO(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public InscripcionDTO crear(@RequestBody Inscripcion inscripcion,
                                 @RequestParam Long idClase) {
        Clase clase = new Clase();
        clase.setIdClase(idClase);
        inscripcion.setClase(clase);
        return service.convertirDTO(service.save(inscripcion));
    }

    @PutMapping("/{id}")
    public InscripcionDTO actualizar(@PathVariable Long id, @RequestBody Inscripcion form,
                                      @RequestParam Long idClase) {
        Inscripcion existente = service.getId(id);
        if (existente != null) {
            existente.setNombreCliente(form.getNombreCliente());
            existente.setFechaInscripcion(form.getFechaInscripcion());
            Clase clase = new Clase();
            clase.setIdClase(idClase);
            existente.setClase(clase);
            return service.convertirDTO(service.save(existente));
        }
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/dto")
    public List<InscripcionDTO> listarConClase() {
        return service.consultaMultitabla();
    }
}