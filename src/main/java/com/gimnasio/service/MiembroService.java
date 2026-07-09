package com.gimnasio.service;

import com.gimnasio.dto.MiembroDTO;
import com.gimnasio.model.Miembro;
import com.gimnasio.model.Plan;
import com.gimnasio.model.Usuario;
import com.gimnasio.repository.MiembroRepository;
import com.gimnasio.repository.PlanRepository;
import com.gimnasio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository data;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanRepository planRepository;

    public List<Miembro> listar() {
        return data.findAll();
    }

    public Optional<Miembro> getId(int id) {
        return data.findById(id);
    }

    public MiembroDTO save(MiembroDTO dto) {
        Miembro m = new Miembro();
        m.setIdMiembro(dto.getIdMiembro());
        m.setFechaInicio(dto.getFechaInicio());
        m.setFechaFin(dto.getFechaFin());
        m.setEstado(dto.getEstado());

        if (dto.getIdUsuario() != null) {
            Optional<Usuario> u = usuarioRepository.findById(dto.getIdUsuario());
            u.ifPresent(m::setUsuario);
        }

        if (dto.getIdPlan() != null) {
            Optional<Plan> p = planRepository.findById(dto.getIdPlan());
            p.ifPresent(m::setPlan);
        }

        Miembro guardado = data.save(m);
        return convertirDTO(guardado);
    }

    public void delete(int id) {
        data.deleteById(id);
    }

    public MiembroDTO convertirDTO(Miembro m) {
        MiembroDTO dto = new MiembroDTO();
        dto.setIdMiembro(m.getIdMiembro());
        dto.setFechaInicio(m.getFechaInicio());
        dto.setFechaFin(m.getFechaFin());
        dto.setEstado(m.getEstado());

        if (m.getUsuario() != null) {
            dto.setIdUsuario(m.getUsuario().getIdUsuario());
            dto.setNombreUsuario(m.getUsuario().getNombres());
            dto.setApellidosUsuario(m.getUsuario().getApellidos());
        }

        if (m.getPlan() != null) {
            dto.setIdPlan(m.getPlan().getIdPlan());
            dto.setNombrePlan(m.getPlan().getNombre());
        }

        return dto;
    }

    public List<MiembroDTO> listarPorPlan(String nombrePlan) {
        return data.buscarPorPlan(nombrePlan)
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public List<MiembroDTO> buscarPorNombreUsuario(String texto) {
        return data.buscarPorNombreUsuario(texto)
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public List<MiembroDTO> buscarPorPlanNative(String nombrePlan) {
        return data.buscarPorPlanNative(nombrePlan)
                .stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public List<MiembroDTO> listarDTO() {
        return data.findAll().stream().map(this::convertirDTO).collect(Collectors.toList());
    }
}