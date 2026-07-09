package com.gimnasio.repository;

import com.gimnasio.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MiembroRepository extends JpaRepository<Miembro, Integer> {

    @Query("SELECT m FROM Miembro m JOIN m.plan p WHERE p.nombre = :nombrePlan")
    List<Miembro> buscarPorPlan(@Param("nombrePlan") String nombrePlan);

    @Query("SELECT m FROM Miembro m JOIN m.usuario u " +
           "WHERE LOWER(u.nombres) LIKE LOWER(CONCAT('%', :texto, '%')) " +
           "OR LOWER(u.apellidos) LIKE LOWER(CONCAT('%', :texto, '%'))")
    List<Miembro> buscarPorNombreUsuario(@Param("texto") String texto);

    @Query(value = "SELECT mi.* FROM miembro mi " +
            "INNER JOIN usuario u ON mi.id_usuario = u.id_usuario " +
            "INNER JOIN plan p ON mi.id_plan = p.id_plan " +
            "WHERE p.nombre LIKE CONCAT('%', :nombrePlan, '%')",
            nativeQuery = true)
    List<Miembro> buscarPorPlanNative(@Param("nombrePlan") String nombrePlan);
}