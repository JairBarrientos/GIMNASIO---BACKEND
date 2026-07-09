package com.gimnasio.repository;

import com.gimnasio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u JOIN u.rol r WHERE r.nombre = :nombreRol")
    List<Usuario> buscarPorRol(@Param("nombreRol") String nombreRol);

    @Query("SELECT u FROM Usuario u WHERE u.nombres LIKE %:texto% OR u.apellidos LIKE %:texto%")
    List<Usuario> buscarPorNombre(@Param("texto") String texto);

    @Query(value = "SELECT u.*, r.nombre AS nombre_rol FROM usuario u INNER JOIN rol r ON u.id_rol = r.id_rol WHERE u.estado = :estado", nativeQuery = true)
    List<Object[]> buscarPorEstadoNative(@Param("estado") String estado);

    Optional<Usuario> findByCorreo(String correo);
}