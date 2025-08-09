package com.darwinruiz.edujspapp.models;

import java.util.List;

public class Profesor {
    private int id;
    private String nombre;
    private String email;
    private String genero;
    private boolean tiempoCompleto;
    private String especialidad;
    private List<String> cursosAsignados;
    private String observaciones;
    private String fechaIngreso;

    public Profesor() {}

    public Profesor(int id, String nombre, String email, String genero, boolean tiempoCompleto,
                    String especialidad, List<String> cursosAsignados, String observaciones, String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.genero = genero;
        this.tiempoCompleto = tiempoCompleto;
        this.especialidad = especialidad;
        this.cursosAsignados = cursosAsignados;
        this.observaciones = observaciones;
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isTiempoCompleto() {
        return tiempoCompleto;
    }

    public void setTiempoCompleto(boolean tiempoCompleto) {
        this.tiempoCompleto = tiempoCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<String> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCursosAsignados(List<String> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
