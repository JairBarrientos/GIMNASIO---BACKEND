package com.gimnasio.dto;

import java.time.LocalDate;

public class InscripcionDTO {
    private Long idInscripcion;
    private LocalDate fechaInscripcion;
    private Long idClase;
    private String nombreClase;
    private Integer idMiembro;
    private String nombreMiembro;

    public Long getIdInscripcion() { return idInscripcion; }
    public void setIdInscripcion(Long idInscripcion) { this.idInscripcion = idInscripcion; }

    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    public Long getIdClase() { return idClase; }
    public void setIdClase(Long idClase) { this.idClase = idClase; }

    public String getNombreClase() { return nombreClase; }
    public void setNombreClase(String nombreClase) { this.nombreClase = nombreClase; }

    public Integer getIdMiembro() { return idMiembro; }
    public void setIdMiembro(Integer idMiembro) { this.idMiembro = idMiembro; }

    public String getNombreMiembro() { return nombreMiembro; }
    public void setNombreMiembro(String nombreMiembro) { this.nombreMiembro = nombreMiembro; }
}