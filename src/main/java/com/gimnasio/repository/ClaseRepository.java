package com.gimnasio.repository;

import com.gimnasio.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, Long> {

    @Query("SELECT c FROM Clase c WHERE c.capacidad >= :capacidad")
    List<Clase> buscarPorCapacidadMinima(@Param("capacidad") Integer capacidad);
}