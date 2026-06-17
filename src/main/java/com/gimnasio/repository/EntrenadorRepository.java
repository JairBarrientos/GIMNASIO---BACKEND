package com.gimnasio.repository;

import com.gimnasio.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {

    @Query("SELECT e FROM Entrenador e JOIN e.especialidad es WHERE es.nombre = :nombre")
    List<Entrenador> buscarPorEspecialidad(@Param("nombre") String nombre);
    
    // JPQL Entrenador estado Activo
    @Query("SELECT e FROM Entrenador e WHERE e.estado = :estado")
    List<Entrenador> buscarPorEstado(@Param("estado") String estado);

    // JPQL buscar por nombre Usuario
    @Query("SELECT e FROM Entrenador e JOIN e.usuario u " +
           "WHERE LOWER(u.nombres) LIKE LOWER(CONCAT('%', :texto, '%')) " +
           "OR LOWER(u.apellidos) LIKE LOWER(CONCAT('%', :texto, '%'))")
    List<Entrenador> buscarPorNombreUsuario(@Param("texto") String texto);

    // Native Query buscar por especialidad
    @Query(value = "SELECT ent.* FROM entrenador ent " +
            "INNER JOIN usuario u ON ent.usuario_id = u.id_usuario " +
            "INNER JOIN especialidad esp ON ent.especialidad_id = esp.id_especialidad " +
            "WHERE esp.nombre LIKE CONCAT('%', :nombreEspecialidad, '%')",
            nativeQuery = true)
    List<Entrenador> buscarPorEspecialidadLikeNative(@Param("nombreEspecialidad") String nombreEspecialidad);
}