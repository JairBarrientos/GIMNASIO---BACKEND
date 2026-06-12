package com.gimnasio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;

    private String nombreCliente;
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_clase")
    private Clase clase;

    public Long getIdInscripcion() { return idInscripcion; }
    public void setIdInscripcion(Long idInscripcion) { this.idInscripcion = idInscripcion; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }
}