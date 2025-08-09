package com.darwinruiz.edujspapp.services;

import com.darwinruiz.edujspapp.models.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorService {
    private static final List<Profesor> profesores = new ArrayList<>();
    private static int secuenciaId = 1;

    public List<Profesor> obtenerTodos() {
        return profesores;
    }

    public void registrar(Profesor profesor) {
        profesor.setId(secuenciaId++);
        profesores.add(profesor);
    }

    public Profesor buscarPorId(int id) {
        return profesores.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void actualizar(Profesor profe) {
        Profesor existente = buscarPorId(profe.getId());
        if (existente != null) {
            existente.setNombre(profe.getNombre());
            existente.setEmail(profe.getEmail());
            existente.setGenero(profe.getGenero());
            existente.setTiempoCompleto(profe.isTiempoCompleto());
            existente.setEspecialidad(profe.getEspecialidad());
            existente.setCursosAsignados(profe.getCursosAsignados());
            existente.setObservaciones(profe.getObservaciones());
            existente.setFechaIngreso(profe.getFechaIngreso());
        }
    }

    public void eliminar(int id) {
        profesores.removeIf(p -> p.getId() == id);
    }
}
