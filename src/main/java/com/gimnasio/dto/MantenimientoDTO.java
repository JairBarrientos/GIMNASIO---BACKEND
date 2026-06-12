package com.gimnasio.dto;

import java.time.LocalDate;

public class MantenimientoDTO {

    private Integer idMantenimiento;
    private LocalDate fecha;
    private String descripcion;
    private Double costo;
    private Integer idEquipamiento;
    private String nombreEquipamiento;

    public Integer getIdMantenimiento() { return idMantenimiento; }
    public void setIdMantenimiento(Integer idMantenimiento) { this.idMantenimiento = idMantenimiento; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }

    public Integer getIdEquipamiento() { return idEquipamiento; }
    public void setIdEquipamiento(Integer idEquipamiento) { this.idEquipamiento = idEquipamiento; }

    public String getNombreEquipamiento() { return nombreEquipamiento; }
    public void setNombreEquipamiento(String nombreEquipamiento) { this.nombreEquipamiento = nombreEquipamiento; }
}
