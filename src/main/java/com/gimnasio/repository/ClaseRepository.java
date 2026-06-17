package com.gimnasio.repository;

import com.gimnasio.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, Long> {

    @Query("SELECT c FROM Clase c WHERE c.capacidad >= :capacidad")
    List<Clase> buscarPorCapacidadMinima(@Param("capacidad") Integer capacidad);

    @Query("SELECT c FROM Clase c JOIN c.inscripciones i WHERE i.nombreCliente LIKE %:texto%")
    List<Clase> buscarPorNombreCliente(@Param("texto") String texto);

    @Query(value = "SELECT c.* FROM clase c INNER JOIN inscripcion i ON i.id_clase = c.id_clase GROUP BY c.id_clase HAVING COUNT(i.id_inscripcion) > 0", nativeQuery = true)
    List<Clase> clasesConInscripciones();
}