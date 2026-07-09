package com.gimnasio.repository;

import com.gimnasio.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

    @Query("SELECT e FROM Especialidad e WHERE e.nombre LIKE %:nombre%")
    List<Especialidad> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT e FROM Especialidad e WHERE e.estado = :estado")
    List<Especialidad> buscarPorEstado(@Param("estado") String estado);

    @Query("SELECT DISTINCT e FROM Especialidad e JOIN e.entrenadores ent WHERE ent.estado = :estadoEntrenador")
    List<Especialidad> buscarConEntrenadoresEnEstado(@Param("estadoEntrenador") String estadoEntrenador);

    @Query(value = "SELECT * FROM especialidad WHERE estado = :estado", nativeQuery = true)
    List<Especialidad> buscarPorEstadoNative(@Param("estado") String estado);

    @Query(value = "SELECT DISTINCT esp.* FROM especialidad esp " +
            "INNER JOIN entrenador ent ON ent.especialidad_id = esp.id_especialidad " +
            "INNER JOIN usuario u ON ent.usuario_id = u.id_usuario " +
            "WHERE ent.estado = :estadoEntrenador",
            nativeQuery = true)
    List<Especialidad> buscarConEntrenadoresEnEstadoNative(@Param("estadoEntrenador") String estadoEntrenador);
}