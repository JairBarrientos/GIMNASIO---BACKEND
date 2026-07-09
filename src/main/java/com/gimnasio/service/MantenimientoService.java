package com.gimnasio.service;

import com.gimnasio.dto.MantenimientoDTO;
import com.gimnasio.model.Entrenador;
import com.gimnasio.model.Equipamiento;
import com.gimnasio.model.Mantenimiento;
import com.gimnasio.repository.EntrenadorRepository;
import com.gimnasio.repository.EquipamientoRepository;
import com.gimnasio.repository.MantenimientoRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final EquipamientoRepository equipamientoRepository;
    private final EntrenadorRepository entrenadorRepository;

    public MantenimientoService(MantenimientoRepository mantenimientoRepository,
                                 EquipamientoRepository equipamientoRepository,
                                 EntrenadorRepository entrenadorRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
        this.equipamientoRepository = equipamientoRepository;
        this.entrenadorRepository = entrenadorRepository;
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
        eq.ifPresent(m::setEquipamiento);

        if (dto.getIdEntrenador() != null) {
            Optional<Entrenador> ent = entrenadorRepository.findById(dto.getIdEntrenador());
            ent.ifPresent(m::setEntrenador);
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

    public List<MantenimientoDTO> buscarPorEntrenadorDTO(Integer idEntrenador) {
        return mantenimientoRepository.buscarPorEntrenador(idEntrenador)
                .stream().map(this::convertirDTO).collect(Collectors.toList());
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
        if (m.getEntrenador() != null) {
            dto.setIdEntrenador(m.getEntrenador().getIdEntrenador());
            if (m.getEntrenador().getUsuario() != null) {
                dto.setNombreEntrenador(m.getEntrenador().getUsuario().getNombres() + " " + m.getEntrenador().getUsuario().getApellidos());
            }
        }
        return dto;
    }
}