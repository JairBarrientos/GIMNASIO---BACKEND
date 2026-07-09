package com.gimnasio.repository;

import com.gimnasio.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query("SELECT r FROM Rol r WHERE r.nombre LIKE %:texto%")
    List<Rol> buscarPorNombre(@Param("texto") String texto);

    @Query("SELECT DISTINCT r FROM Rol r JOIN r.usuarios u WHERE u.estado = :estado")
    List<Rol> buscarConUsuariosEnEstado(@Param("estado") String estado);

    @Query(value = "SELECT r.*, COUNT(u.id_usuario) AS total_usuarios FROM rol r INNER JOIN usuario u ON u.id_rol = r.id_rol GROUP BY r.id_rol", nativeQuery = true)
    List<Object[]> contarUsuariosPorRol();

    @Query("SELECT r FROM Rol r WHERE r.nombre = :nombre")
    Optional<Rol> buscarPorNombreExacto(@Param("nombre") String nombre);
}