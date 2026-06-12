package com.gimnasio.repository;

import com.gimnasio.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MiembroRepository extends JpaRepository<Miembro, Integer> {

    @Query("SELECT m FROM Miembro m JOIN m.plan p WHERE p.nombre = :nombrePlan")
    List<Miembro> buscarPorPlan(@Param("nombrePlan") String nombrePlan);
}