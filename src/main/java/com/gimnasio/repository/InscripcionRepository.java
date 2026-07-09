package com.gimnasio.repository;

import com.gimnasio.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    @Query("SELECT i FROM Inscripcion i JOIN FETCH i.clase c")
    List<Inscripcion> listarConClase();

    @Query("SELECT i FROM Inscripcion i JOIN i.miembro m WHERE m.idMiembro = :idMiembro")
    List<Inscripcion> buscarPorMiembro(@Param("idMiembro") Integer idMiembro);

    @Query("SELECT i FROM Inscripcion i JOIN i.miembro m JOIN m.usuario u " +
           "WHERE LOWER(u.nombres) LIKE LOWER(CONCAT('%', :texto, '%')) " +
           "OR LOWER(u.apellidos) LIKE LOWER(CONCAT('%', :texto, '%'))")
    List<Inscripcion> buscarPorNombreMiembro(@Param("texto") String texto);

    @Query(value = "SELECT i.* FROM inscripcion i " +
            "INNER JOIN clase c ON i.id_clase = c.id_clase " +
            "INNER JOIN miembro mi ON i.id_miembro = mi.id_miembro " +
            "INNER JOIN usuario u ON mi.id_usuario = u.id_usuario " +
            "WHERE c.nombre LIKE CONCAT('%', :nombreClase, '%')",
            nativeQuery = true)
    List<Inscripcion> buscarPorNombreClaseNative(@Param("nombreClase") String nombreClase);
}