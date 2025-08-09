package com.darwinruiz.edujspapp.controllers;


import com.darwinruiz.edujspapp.models.Profesor;
import com.darwinruiz.edujspapp.services.ProfesorService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/profesores")
public class ProfesorControlador extends HttpServlet {
    private final ProfesorService service = new ProfesorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) accion = "formulario";

        switch (accion) {
            case "listar" -> {
                request.setAttribute("profesores", service.obtenerTodos());
                request.setAttribute("vista", "/views/profesores/lista_profesores.jsp");
            }
            case "editar" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                Profesor profesor = service.buscarPorId(id);
                request.setAttribute("profesor", profesor);
                request.setAttribute("vista", "/views/profesores/formulario_profesor.jsp");
            }
            case "eliminar" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                service.eliminar(id);
                response.sendRedirect("profesores?accion=listar");
                return;
            }
            default -> request.setAttribute("vista", "/views/profesores/formulario_profesor.jsp");
        }

        request.getRequestDispatcher("plantilla.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idTexto = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String genero = request.getParameter("genero");
        boolean tiempoCompleto = request.getParameter("tiempoCompleto") != null;
        String especialidad = request.getParameter("especialidad");
        String[] cursos = request.getParameterValues("cursos");
        String observaciones = request.getParameter("observaciones");
        String fechaIngreso = request.getParameter("fechaIngreso");

        Profesor profe = new Profesor(
                idTexto != null && !idTexto.isBlank() ? Integer.parseInt(idTexto) : 0,
                nombre,
                email,
                genero,
                tiempoCompleto,
                especialidad,
                cursos != null ? List.of(cursos) : List.of(),
                observaciones,
                fechaIngreso
        );

        if (idTexto == null || idTexto.isBlank()) {
            service.registrar(profe);
        } else {
            service.actualizar(profe);
        }

        response.sendRedirect("profesores?accion=listar");
    }
}