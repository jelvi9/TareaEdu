package com.darwinruiz.edujspapp.services;

import com.darwinruiz.edujspapp.models.Carrera;

import java.util.ArrayList;
import java.util.List;

public class CarreraService {
    private static final List<Carrera> carreras = new ArrayList<>();
    private static int secuenciaId = 1;

    public List<Carrera> obtenerTodas() {
        return carreras;
    }

    public Carrera buscarPorId(int id) {
        return carreras.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void registrar(Carrera c) {
        c.setId(secuenciaId++);
        carreras.add(c);
    }

    public void actualizar(Carrera c) {
        Carrera existente = buscarPorId(c.getId());
        if (existente != null) {
            existente.setNombre(c.getNombre());
            existente.setCodigo(c.getCodigo());
            existente.setFacultad(c.getFacultad());
            existente.setNivel(c.getNivel());
            existente.setModalidades(c.getModalidades());
            existente.setEstadoActiva(c.isEstadoActiva());
            existente.setDescripcion(c.getDescripcion());
        }
    }

    public void eliminar(int id) {
        carreras.removeIf(c -> c.getId() == id);
    }
}