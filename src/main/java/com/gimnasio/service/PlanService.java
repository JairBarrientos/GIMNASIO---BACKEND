package com.gimnasio.service;

import com.gimnasio.dto.PlanDTO;
import com.gimnasio.model.Plan;
import com.gimnasio.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlanRepository data;

    public List<Plan> listar() {
        return data.findAll();
    }

    public Optional<Plan> getId(int id) {
        return data.findById(id);
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
}