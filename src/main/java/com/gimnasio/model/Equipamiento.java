package com.gimnasio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipamiento")
public class Equipamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipamiento;

    private String nombre;
    private String estado;
    private String area;

    public Integer getIdEquipamiento() { return idEquipamiento; }
    public void setIdEquipamiento(Integer idEquipamiento) { this.idEquipamiento = idEquipamiento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
}
