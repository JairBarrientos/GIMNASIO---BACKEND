package com.gimnasio.dto;

public class ClaseDTO {

    private Long idClase;
    private String nombre;
    private String horario;
    private Integer capacidad;
    private Integer totalInscripciones;

    public Long getIdClase() { return idClase; }
    public void setIdClase(Long idClase) { this.idClase = idClase; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public Integer getTotalInscripciones() { return totalInscripciones; }
    public void setTotalInscripciones(Integer totalInscripciones) { this.totalInscripciones = totalInscripciones; }
}