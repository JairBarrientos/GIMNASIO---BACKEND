package com.gimnasio.repository;

import com.gimnasio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u JOIN u.rol r WHERE r.nombre = :nombreRol")
    List<Usuario> buscarPorRol(@Param("nombreRol") String nombreRol);
}