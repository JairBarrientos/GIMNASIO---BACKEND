package com.gimnasio.repository;

import com.gimnasio.model.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipamientoRepository extends JpaRepository<Equipamiento, Integer> {

    @Query("SELECT e FROM Equipamiento e WHERE e.area LIKE %:area%")
    List<Equipamiento> buscarPorArea(@Param("area") String area);

    @Query("SELECT e FROM Equipamiento e WHERE e.estado = :estado")
    List<Equipamiento> buscarPorEstado(@Param("estado") String estado);

    @Query(value = "SELECT eq.* FROM equipamiento eq INNER JOIN mantenimiento m ON m.id_equipamiento = eq.id_equipamiento GROUP BY eq.id_equipamiento", nativeQuery = true)
    List<Equipamiento> equipamientoConMantenimiento();
}