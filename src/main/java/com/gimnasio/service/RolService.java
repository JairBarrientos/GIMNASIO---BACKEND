package com.gimnasio.service;

import com.gimnasio.dto.RolDTO;
import com.gimnasio.model.Rol;
import com.gimnasio.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository data;

    public List<RolDTO> listar() {
        return data.findAll().stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public Optional<Rol> getId(int id) {
        return data.findById(id);
    }

    public Optional<RolDTO> getByIdDTO(int id) {
        return data.findById(id).map(this::convertirDTO);
    }

    public int save(Rol r) {
        Rol saved = data.save(r);
        return saved != null ? 1 : 0;
    }

    public void delete(int id) {
        data.deleteById(id);
    }

    public RolDTO convertirDTO(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setIdRol(rol.getIdRol());
        dto.setNombre(rol.getNombre());
        dto.setDescripcion(rol.getDescripcion());
        return dto;
    }

    public List<RolDTO> buscarPorNombre(String texto) {
        return data.buscarPorNombre(texto).stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public List<Object[]> contarUsuariosPorRol() {
        return data.contarUsuariosPorRol();
    }
    
    public List<RolDTO> buscarConUsuariosEnEstado(String estado) {
        return data.buscarConUsuariosEnEstado(estado).stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }
}