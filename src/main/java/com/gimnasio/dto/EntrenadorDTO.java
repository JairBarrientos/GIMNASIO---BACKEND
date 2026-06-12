package com.gimnasio.dto;

public class EntrenadorDTO {
    private Integer idEntrenador;
    private String estado;
    private Integer idUsuario;
    private String nombreUsuario;
    private Integer idEspecialidad;
    private String nombreEspecialidad;

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
}