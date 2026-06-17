package com.gimnasio.service;

import com.gimnasio.dto.InscripcionDTO;
import com.gimnasio.model.Inscripcion;
import com.gimnasio.repository.InscripcionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {

    private final InscripcionRepository repository;

    public InscripcionService(InscripcionRepository repository) {
        this.repository = repository;
    }

    public List<Inscripcion> listar() {
        return repository.findAll();
    }

    public Inscripcion getId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Inscripcion save(Inscripcion inscripcion) {
        return repository.save(inscripcion);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public InscripcionDTO convertirDTO(Inscripcion i) {
        InscripcionDTO dto = new InscripcionDTO();
        dto.setIdInscripcion(i.getIdInscripcion());
        dto.setNombreCliente(i.getNombreCliente());
        dto.setFechaInscripcion(i.getFechaInscripcion());
        dto.setNombreClase(i.getClase().getNombre());
        return dto;
    }

    public List<InscripcionDTO> consultaMultitabla() {
        return repository.listarConClase()
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }
    
    public List<InscripcionDTO> listarDTO() {
        return repository.findAll().stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public InscripcionDTO getByIdDTO(Long id) {
        Inscripcion i = repository.findById(id).orElse(null);
        return i != null ? convertirDTO(i) : null;
    }
}