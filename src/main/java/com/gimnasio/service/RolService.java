package com.gimnasio.service;

import com.gimnasio.dto.RolDTO;
import com.gimnasio.model.Rol;
import com.gimnasio.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository data;

    public List<Rol> listar() {
        return (List<Rol>) data.findAll();
    }

    public Optional<Rol> getId(int id) {
        return data.findById(id);
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
}