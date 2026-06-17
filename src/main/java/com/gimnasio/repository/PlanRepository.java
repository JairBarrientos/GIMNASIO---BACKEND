package com.gimnasio.repository;

import com.gimnasio.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query("SELECT p FROM Plan p WHERE p.nombre LIKE %:texto%")
    List<Plan> buscarPorNombre(@Param("texto") String texto);

    @Query("SELECT p FROM Plan p WHERE p.precio <= :precio")
    List<Plan> buscarPorPrecioMaximo(@Param("precio") Double precio);

    @Query("SELECT p FROM Plan p JOIN p.miembros m WHERE m.estado = :estado")
    List<Plan> buscarConMiembrosEnEstado(@Param("estado") String estado);

    @Query(value = "SELECT * FROM plan WHERE duracion_dias >= :dias", nativeQuery = true)
    List<Plan> buscarPorDuracionMinimaNative(@Param("dias") Integer dias);
}