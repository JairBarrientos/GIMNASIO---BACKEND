package com.gimnasio.service;

import com.gimnasio.dto.ClaseDTO;
import com.gimnasio.model.Clase;
import com.gimnasio.repository.ClaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaseService {

    private final ClaseRepository repository;

    public ClaseService(ClaseRepository repository) {
        this.repository = repository;
    }

    public List<ClaseDTO> listar() {
        return repository.findAll().stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public ClaseDTO getId(Long id) {
        Clase clase = repository.findById(id).orElse(null);
        return clase != null ? convertirDTO(clase) : null;
    }

    public Clase save(Clase clase) {
        return repository.save(clase);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ClaseDTO convertirDTO(Clase clase) {
        ClaseDTO dto = new ClaseDTO();
        dto.setIdClase(clase.getIdClase());
        dto.setNombre(clase.getNombre());
        dto.setHorario(clase.getHorario());
        dto.setCapacidad(clase.getCapacidad());
        dto.setTotalInscripciones(
            clase.getInscripciones() != null ? clase.getInscripciones().size() : 0
        );
        return dto;
    }

    public List<ClaseDTO> buscarPorNombreMiembro(String texto) {
        return repository.buscarPorNombreMiembro(texto).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<Clase> clasesConInscripciones() {
        return repository.clasesConInscripciones();
    }
}