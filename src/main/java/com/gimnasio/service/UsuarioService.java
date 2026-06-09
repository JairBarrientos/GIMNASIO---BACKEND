package com.gimnasio.service;

import com.gimnasio.dto.UsuarioDTO;
import com.gimnasio.model.Usuario;
import com.gimnasio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository data;

    public List<Usuario> listar() {
        return (List<Usuario>) data.findAll();
    }

    public Optional<Usuario> getId(int id) {
        return data.findById(id);
    }

    public int save(Usuario u) {
        Usuario saved = data.save(u);
        return saved != null ? 1 : 0;
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
            dto.setNombreRol(u.getRol().getNombre());
        }
        return dto;
    }

    public List<UsuarioDTO> listarPorRol(String nombreRol) {
        List<Usuario> lista = data.buscarPorRol(nombreRol);
        return lista.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());
    }
}