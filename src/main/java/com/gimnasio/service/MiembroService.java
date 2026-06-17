package com.gimnasio.service;

import com.gimnasio.dto.MiembroDTO;
import com.gimnasio.model.Miembro;
import com.gimnasio.repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository data;

    public List<Miembro> listar() {
        return data.findAll();
    }

    public Optional<Miembro> getId(int id) {
        return data.findById(id);
    }

    public int save(Miembro m) {
        Miembro saved = data.save(m);
        return saved != null ? 1 : 0;
    }

    public void delete(int id) {
        data.deleteById(id);
    }

    public MiembroDTO convertirDTO(Miembro m) {
        MiembroDTO dto = new MiembroDTO();
        dto.setIdMiembro(m.getIdMiembro());
        dto.setNombreUsuario(m.getUsuario().getNombres());
        dto.setApellidosUsuario(m.getUsuario().getApellidos());
        dto.setNombrePlan(m.getPlan().getNombre());
        dto.setFechaInicio(m.getFechaInicio());
        dto.setFechaFin(m.getFechaFin());
        dto.setEstado(m.getEstado());
        return dto;
    }

    public List<MiembroDTO> listarPorPlan(String nombrePlan) {
        return data.buscarPorPlan(nombrePlan)
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }
    
    public List<MiembroDTO> listarDTO() {
        return data.findAll().stream().map(this::convertirDTO).collect(Collectors.toList());
    }
}