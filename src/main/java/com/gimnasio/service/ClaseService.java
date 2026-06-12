package com.gimnasio.service;

import com.gimnasio.dto.ClaseDTO;
import com.gimnasio.model.Clase;
import com.gimnasio.repository.ClaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClaseService {

    private final ClaseRepository repository;

    public ClaseService(ClaseRepository repository) {
        this.repository = repository;
    }

    public List<Clase> listar() {
        return repository.findAll();
    }

    public Clase getId(Long id) {
        return repository.findById(id).orElse(null);
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
        return dto;
    }
}