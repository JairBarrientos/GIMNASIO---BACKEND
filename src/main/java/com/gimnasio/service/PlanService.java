package com.gimnasio.service;

import com.gimnasio.dto.PlanDTO;
import com.gimnasio.model.Plan;
import com.gimnasio.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanService {

    @Autowired
    private PlanRepository data;

    public List<PlanDTO> listar() {
        return data.findAll().stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public Optional<Plan> getId(int id) {
        return data.findById(id);
    }

    public Optional<PlanDTO> getByIdDTO(int id) {
        return data.findById(id).map(this::convertirDTO);
    }

    public int save(Plan p) {
        Plan saved = data.save(p);
        return saved != null ? 1 : 0;
    }

    public void delete(int id) {
        data.deleteById(id);
    }

    public PlanDTO convertirDTO(Plan p) {
        PlanDTO dto = new PlanDTO();
        dto.setIdPlan(p.getIdPlan());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setPrecio(p.getPrecio());
        dto.setDuracionDias(p.getDuracionDias());
        return dto;
    }

    public List<PlanDTO> buscarPorNombre(String texto) {
        return data.buscarPorNombre(texto).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<PlanDTO> buscarPorPrecioMaximo(Double precio) {
        return data.buscarPorPrecioMaximo(precio).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<PlanDTO> buscarConMiembrosEnEstado(String estado) {
        return data.buscarConMiembrosEnEstado(estado).stream().map(this::convertirDTO).collect(Collectors.toList());
    }

    public List<Plan> buscarPorDuracionMinimaNative(Integer dias) {
        return data.buscarPorDuracionMinimaNative(dias);
    }
}