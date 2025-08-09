package com.darwinruiz.edujspapp.repositories;

import com.darwinruiz.edujspapp.models.Alumno;

import java.util.ArrayList;
import java.util.List;

public class AlumnoRepositorio {
    private static final List<Alumno> alumnos = new ArrayList<>();
    private static int secuenciaId = 1;

    // Método explícito para inicializar datos
    public AlumnoRepositorio() {
        if (alumnos.isEmpty()) {
            inicializarDatos();
        }
    }

    private void inicializarDatos() {
        alumnos.add(new Alumno(secuenciaId++, "María Pérez", "Ingeniería en Sistemas"));
        alumnos.add(new Alumno(secuenciaId++, "Luis Gómez", "Administración"));
        alumnos.add(new Alumno(secuenciaId++, "Ana Martínez", "Derecho"));
    }

    public List<Alumno> listar() {
        return alumnos;
    }

    public void agregar(Alumno alumno) {
        alumno.setId(secuenciaId++);
        alumnos.add(alumno);
    }

    public Alumno buscarPorId(int id) {
        for (Alumno a : alumnos) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public void actualizar(Alumno alumno) {
        Alumno existente = buscarPorId(alumno.getId());
        if (existente != null) {
            existente.setNombre(alumno.getNombre());
            existente.setCarrera(alumno.getCarrera());
        }
    }

    public void eliminar(int id) {
        alumnos.removeIf(a -> a.getId() == id);
    }
}
