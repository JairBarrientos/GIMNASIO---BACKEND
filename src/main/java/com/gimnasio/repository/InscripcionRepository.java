package com.gimnasio.repository;

import com.gimnasio.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    @Query("SELECT i FROM Inscripcion i JOIN FETCH i.clase c")
    List<Inscripcion> listarConClase();
}