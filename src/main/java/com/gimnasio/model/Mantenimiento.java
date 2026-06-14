package com.gimnasio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMantenimiento;

    private LocalDate fecha;
    private String descripcion;
    private Double costo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_equipamiento")
    private Equipamiento equipamiento;

    public Integer getIdMantenimiento() { return idMantenimiento; }
    public void setIdMantenimiento(Integer idMantenimiento) { this.idMantenimiento = idMantenimiento; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }

    public Equipamiento getEquipamiento() { return equipamiento; }
    public void setEquipamiento(Equipamiento equipamiento) { this.equipamiento = equipamiento; }
}