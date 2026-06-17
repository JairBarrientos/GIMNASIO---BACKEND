package com.gimnasio.service;

import com.gimnasio.dto.EspecialidadDTO;
import com.gimnasio.model.Especialidad;
import com.gimnasio.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository data;

    public List<Especialidad> listar() {
        return data.findAll();
    }

    public Optional<Especialidad> getId(int id) {
        return data.findById(id);
    }

    public int save(Especialidad e) {
        Especialidad saved = data.save(e);
        return saved != null ? 1 : 0;
    }

    public void delete(int id) {
        data.deleteById(id);
    }

    public EspecialidadDTO convertirDTO(Especialidad e) {
        EspecialidadDTO dto = new EspecialidadDTO();
        dto.setIdEspecialidad(e.getIdEspecialidad());
        dto.setNombre(e.getNombre());
        dto.setDescripcion(e.getDescripcion());
        dto.setEstado(e.getEstado());
        return dto;
    }

    public List<EspecialidadDTO> listarDTO() {
        return data.findAll().stream().map(this::convertirDTO).collect(Collectors.toList());
    }
    
    public List<EspecialidadDTO> buscarPorNombreDTO(String nombre) {
        return data.buscarPorNombre(nombre).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<EspecialidadDTO> buscarPorEstadoDTO(String estado) {
        return data.buscarPorEstado(estado).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<EspecialidadDTO> buscarConEntrenadoresEnEstadoDTO(String estadoEntrenador) {
        return data.buscarConEntrenadoresEnEstado(estadoEntrenador).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<EspecialidadDTO> buscarPorEstadoNativeDTO(String estado) {
        return data.buscarPorEstadoNative(estado).stream().map(this::convertirDTO).collect(Collectors.toList());
    }
}