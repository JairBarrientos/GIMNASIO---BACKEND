package com.gimnasio.repository;

import com.gimnasio.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {

    @Query("SELECT e FROM Entrenador e JOIN e.especialidad es WHERE es.nombre = :nombre")
    List<Entrenador> buscarPorEspecialidad(@Param("nombre") String nombre);
}