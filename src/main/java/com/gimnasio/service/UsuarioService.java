package com.gimnasio.service;

import com.gimnasio.dto.UsuarioDTO;
import com.gimnasio.model.Rol;
import com.gimnasio.model.Usuario;
import com.gimnasio.repository.RolRepository;
import com.gimnasio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository data;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioDTO> listar() {
        return data.findAll().stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public Optional<Usuario> getId(int id) {
        return data.findById(id);
    }

    public Optional<UsuarioDTO> getByIdDTO(int id) {
        return data.findById(id).map(this::convertirDTO);
    }

    public UsuarioDTO crear(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNombres(dto.getNombres());
        u.setApellidos(dto.getApellidos());
        u.setCorreo(dto.getCorreo());
        u.setTelefono(dto.getTelefono());
        u.setEstado(dto.getEstado());
        u.setPassword(passwordEncoder.encode(dto.getPassword()));

        if (dto.getIdRol() != null) {
            Optional<Rol> rol = rolRepository.findById(dto.getIdRol());
            rol.ifPresent(u::setRol);
        }

        Usuario guardado = data.save(u);
        return convertirDTO(guardado);
    }

    public UsuarioDTO actualizar(int id, UsuarioDTO dto) {
        Optional<Usuario> optional = data.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Usuario u = optional.get();
        u.setNombres(dto.getNombres());
        u.setApellidos(dto.getApellidos());
        u.setCorreo(dto.getCorreo());
        u.setTelefono(dto.getTelefono());
        u.setEstado(dto.getEstado());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            u.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getIdRol() != null) {
            Optional<Rol> rol = rolRepository.findById(dto.getIdRol());
            rol.ifPresent(u::setRol);
        }

        Usuario guardado = data.save(u);
        return convertirDTO(guardado);
    }

    public void delete(int id) {
        data.deleteById(id);
    }

    public UsuarioDTO convertirDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(u.getIdUsuario());
        dto.setNombres(u.getNombres());
        dto.setApellidos(u.getApellidos());
        dto.setCorreo(u.getCorreo());
        dto.setTelefono(u.getTelefono());
        dto.setEstado(u.getEstado());
        if (u.getRol() != null) {
            dto.setIdRol(u.getRol().getIdRol());
            dto.setNombreRol(u.getRol().getNombre());
        }
        return dto;
    }

    public List<UsuarioDTO> listarPorRol(String nombreRol) {
        return data.buscarPorRol(nombreRol).stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> buscarPorNombre(String texto) {
        return data.buscarPorNombre(texto).stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }
}