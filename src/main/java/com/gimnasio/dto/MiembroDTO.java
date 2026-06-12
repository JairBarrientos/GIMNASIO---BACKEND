package com.gimnasio.dto;

import java.time.LocalDate;

public class MiembroDTO {
    private Integer idMiembro;
    private String nombreUsuario;
    private String apellidosUsuario;
    private String nombrePlan;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;

    public Integer getIdMiembro() { return idMiembro; }
    public void setIdMiembro(Integer idMiembro) { this.idMiembro = idMiembro; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getApellidosUsuario() { return apellidosUsuario; }
    public void setApellidosUsuario(String apellidosUsuario) { this.apellidosUsuario = apellidosUsuario; }

    public String getNombrePlan() { return nombrePlan; }
    public void setNombrePlan(String nombrePlan) { this.nombrePlan = nombrePlan; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}