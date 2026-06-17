package com.gimnasio.service;

import com.gimnasio.dto.EntrenadorDTO;
import com.gimnasio.model.Entrenador;
import com.gimnasio.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository data;

    public List<Entrenador> listar() {
        return data.findAll();
    }

    public Optional<Entrenador> getId(int id) {
        return data.findById(id);
    }

    public int save(Entrenador e) {
        Entrenador saved = data.save(e);
        return saved != null ? 1 : 0;
    }

    public void delete(int id) {
        data.deleteById(id);
    }

    public EntrenadorDTO convertirDTO(Entrenador e) {
        EntrenadorDTO dto = new EntrenadorDTO();
        dto.setIdEntrenador(e.getIdEntrenador());
        dto.setEstado(e.getEstado());

        if (e.getUsuario() != null) {
            dto.setIdUsuario(e.getUsuario().getIdUsuario());
            dto.setNombreUsuario(e.getUsuario().getNombres() + " " + e.getUsuario().getApellidos());
        }

        if (e.getEspecialidad() != null) {
            dto.setIdEspecialidad(e.getEspecialidad().getIdEspecialidad());
            dto.setNombreEspecialidad(e.getEspecialidad().getNombre());
        }

        return dto;
    }

    public List<EntrenadorDTO> listarDTO() {
        return data.findAll().stream().map(this::convertirDTO).collect(Collectors.toList());
    }
    
    public List<EntrenadorDTO> buscarPorEspecialidadDTO(String nombre) {
        return data.buscarPorEspecialidad(nombre).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<EntrenadorDTO> buscarPorEstadoDTO(String estado) {
        return data.buscarPorEstado(estado).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<EntrenadorDTO> buscarPorNombreUsuarioDTO(String texto) {
        return data.buscarPorNombreUsuario(texto).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<EntrenadorDTO> buscarPorEspecialidadLikeNativeDTO(String nombreEspecialidad) {
        return data.buscarPorEspecialidadLikeNative(nombreEspecialidad).stream().map(this::convertirDTO).collect(Collectors.toList());
    }
}