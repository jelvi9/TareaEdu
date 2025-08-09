package com.darwinruiz.edujspapp.services;

import com.darwinruiz.edujspapp.models.Alumno;
import com.darwinruiz.edujspapp.repositories.AlumnoRepositorio;

import java.util.List;

public class AlumnoService {
    private final AlumnoRepositorio repositorio = new AlumnoRepositorio();

    public List<Alumno> obtenerTodos() {
        return repositorio.listar();
    }

    public void registrar(String nombre, String carrera) {
        Alumno nuevo = new Alumno(0, nombre, carrera);
        repositorio.agregar(nuevo);
    }

    public Alumno buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public void actualizar(int id, String nombre, String carrera) {
        Alumno actualizado = new Alumno(id, nombre, carrera);
        repositorio.actualizar(actualizado);
    }

    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
}
