package com.darwinruiz.edujspapp.controllers;

import com.darwinruiz.edujspapp.models.Alumno;
import com.darwinruiz.edujspapp.services.AlumnoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/alumnos")
public class AlumnoControlador extends HttpServlet {
    private final AlumnoService service = new AlumnoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) accion = "listar";

        switch (accion) {
            case "nuevo" -> mostrarFormularioNuevo(request, response);
            case "editar" -> mostrarFormularioEditar(request, response);
            case "eliminar" -> eliminarAlumno(request, response);
            default -> listarAlumnos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {
            String idTexto = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String carrera = request.getParameter("carrera");

            if (idTexto == null || idTexto.isBlank()) {
                // Crear nuevo
                service.registrar(nombre, carrera);
            } else {
                // Actualizar
                int id = Integer.parseInt(idTexto);
                service.actualizar(id, nombre, carrera);
            }
            response.sendRedirect("alumnos");
        }
    }

    private void listarAlumnos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Alumno> lista = service.obtenerTodos();
        request.setAttribute("alumnos", lista);
        request.setAttribute("vista", "/views/alumnos/alumnos.jsp");
        request.getRequestDispatcher("/plantilla.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("vista", "/views/alumnos/formulario.jsp");
        request.getRequestDispatcher("/plantilla.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Alumno alumno = service.buscarPorId(id);
        request.setAttribute("alumno", alumno);
        request.setAttribute("vista", "/views/alumnos/formulario.jsp");
        request.getRequestDispatcher("/plantilla.jsp").forward(request, response);
    }

    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.eliminar(id);
        response.sendRedirect("alumnos");
    }
}
