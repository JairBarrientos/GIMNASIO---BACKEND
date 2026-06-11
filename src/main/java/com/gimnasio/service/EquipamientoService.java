package com.gimnasio.service;

import com.gimnasio.dto.EquipamientoDTO;
import com.gimnasio.model.Equipamiento;
import com.gimnasio.repository.EquipamientoRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamientoService {

    private final EquipamientoRepository equipamientoRepository;

    public EquipamientoService(EquipamientoRepository equipamientoRepository) {
        this.equipamientoRepository = equipamientoRepository;
    }

    public List<EquipamientoDTO> listar() {
        List<Equipamiento> lista = equipamientoRepository.findAll();
        List<EquipamientoDTO> listaDTO = new ArrayList<>();
        for (Equipamiento e : lista) {
            listaDTO.add(convertirDTO(e));
        }
        return listaDTO;
    }

    public EquipamientoDTO getId(Integer id) {
        Optional<Equipamiento> opcional = equipamientoRepository.findById(id);
        if (opcional.isPresent()) {
            return convertirDTO(opcional.get());
        }
        return null;
    }

    public EquipamientoDTO save(EquipamientoDTO dto) {
        Equipamiento e = new Equipamiento();
        e.setIdEquipamiento(dto.getIdEquipamiento());
        e.setNombre(dto.getNombre());
        e.setEstado(dto.getEstado());
        e.setArea(dto.getArea());
        Equipamiento guardado = equipamientoRepository.save(e);
        return convertirDTO(guardado);
    }

    public void delete(Integer id) {
        equipamientoRepository.deleteById(id);
    }

    public EquipamientoDTO convertirDTO(Equipamiento e) {
        EquipamientoDTO dto = new EquipamientoDTO();
        dto.setIdEquipamiento(e.getIdEquipamiento());
        dto.setNombre(e.getNombre());
        dto.setEstado(e.getEstado());
        dto.setArea(e.getArea());
        return dto;
    }
}
