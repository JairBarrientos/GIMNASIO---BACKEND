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
}
