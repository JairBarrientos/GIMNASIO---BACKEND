package com.gimnasio.service;

import com.gimnasio.dto.MantenimientoDTO;
import com.gimnasio.model.Equipamiento;
import com.gimnasio.model.Mantenimiento;
import com.gimnasio.repository.EquipamientoRepository;
import com.gimnasio.repository.MantenimientoRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final EquipamientoRepository equipamientoRepository;

    public MantenimientoService(MantenimientoRepository mantenimientoRepository, EquipamientoRepository equipamientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
        this.equipamientoRepository = equipamientoRepository;
    }

    public List<MantenimientoDTO> listar() {
        List<Mantenimiento> lista = mantenimientoRepository.findAll();
        List<MantenimientoDTO> listaDTO = new ArrayList<>();
        for (Mantenimiento m : lista) {
            listaDTO.add(convertirDTO(m));
        }
        return listaDTO;
    }

    public MantenimientoDTO getId(Integer id) {
        Optional<Mantenimiento> opcional = mantenimientoRepository.findById(id);
        if (opcional.isPresent()) {
            return convertirDTO(opcional.get());
        }
        return null;
    }

    public MantenimientoDTO save(MantenimientoDTO dto) {
        Mantenimiento m = new Mantenimiento();
        m.setIdMantenimiento(dto.getIdMantenimiento());
        m.setFecha(dto.getFecha());
        m.setDescripcion(dto.getDescripcion());
        m.setCosto(dto.getCosto());

        Optional<Equipamiento> eq = equipamientoRepository.findById(dto.getIdEquipamiento());
        if (eq.isPresent()) {
            m.setEquipamiento(eq.get());
        }

        Mantenimiento guardado = mantenimientoRepository.save(m);
        return convertirDTO(guardado);
    }

    public void delete(Integer id) {
        mantenimientoRepository.deleteById(id);
    }

    public List<MantenimientoDTO> consultaMultitabla(String area) {
        List<Mantenimiento> lista = mantenimientoRepository.buscarMantenimientosPorAreaEquipamiento(area);
        List<MantenimientoDTO> listaDTO = new ArrayList<>();
        for (Mantenimiento m : lista) {
            listaDTO.add(convertirDTO(m));
        }
        return listaDTO;
    }

    public MantenimientoDTO convertirDTO(Mantenimiento m) {
        MantenimientoDTO dto = new MantenimientoDTO();
        dto.setIdMantenimiento(m.getIdMantenimiento());
        dto.setFecha(m.getFecha());
        dto.setDescripcion(m.getDescripcion());
        dto.setCosto(m.getCosto());
        if (m.getEquipamiento() != null) {
            dto.setIdEquipamiento(m.getEquipamiento().getIdEquipamiento());
            dto.setNombreEquipamiento(m.getEquipamiento().getNombre());
        }
        return dto;
    }
}
