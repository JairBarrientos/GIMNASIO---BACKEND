package com.gimnasio.repository;

import com.gimnasio.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {

    @Query("SELECT m FROM Mantenimiento m JOIN m.equipamiento e WHERE e.area = :area")
    List<Mantenimiento> buscarMantenimientosPorAreaEquipamiento(@Param("area") String area);

    @Query("SELECT m FROM Mantenimiento m JOIN m.entrenador ent WHERE ent.idEntrenador = :idEntrenador")
    List<Mantenimiento> buscarPorEntrenador(@Param("idEntrenador") Integer idEntrenador);

    @Query(value = "SELECT m.* FROM mantenimiento m " +
            "INNER JOIN equipamiento eq ON m.id_equipamiento = eq.id_equipamiento " +
            "INNER JOIN entrenador ent ON m.id_entrenador = ent.id_entrenador " +
            "INNER JOIN usuario u ON ent.usuario_id = u.id_usuario " +
            "WHERE eq.area LIKE CONCAT('%', :area, '%')",
            nativeQuery = true)
    List<Mantenimiento> buscarPorAreaConEntrenadorNative(@Param("area") String area);
}