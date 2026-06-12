package com.gimnasio.dto;

import java.time.LocalDate;

public class InscripcionDTO {
    private Long idInscripcion;
    private String nombreCliente;
    private LocalDate fechaInscripcion;
    private String nombreClase;

    public Long getIdInscripcion() { return idInscripcion; }
    public void setIdInscripcion(Long idInscripcion) { this.idInscripcion = idInscripcion; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    public String getNombreClase() { return nombreClase; }
    public void setNombreClase(String nombreClase) { this.nombreClase = nombreClase; }
}