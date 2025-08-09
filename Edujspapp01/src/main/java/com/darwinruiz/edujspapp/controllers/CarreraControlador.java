package com.darwinruiz.edujspapp.controllers;

import com.darwinruiz.edujspapp.models.Carrera;
import com.darwinruiz.edujspapp.services.CarreraService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/carreras")
public class CarreraControlador extends HttpServlet {
    private final CarreraService service = new CarreraService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion == null || accion.isBlank()) {
            // por defecto mostrar formulario de registro
            request.setAttribute("vista", "/views/carreras/formulario_carrera.jsp");
            request.getRequestDispatcher("/plantilla.jsp").forward(request, response);
            return;
        }

        switch (accion) {
            case "listar" -> {
                List<Carrera> listado = service.obtenerTodas();
                request.setAttribute("carreras", listado);
                request.setAttribute("vista", "/views/carreras/lista_carreras.jsp");
                request.getRequestDispatcher("/plantilla.jsp").forward(request, response);
            }
            case "editar" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                Carrera car = service.buscarPorId(id);
                request.setAttribute("carrera", car);
                request.setAttribute("vista", "/views/carreras/formulario_carrera.jsp");
                request.getRequestDispatcher("/plantilla.jsp").forward(request, response);
            }
            case "eliminar" -> {
                int id = Integer.parseInt(request.getParameter("id"));
                service.eliminar(id);
                response.sendRedirect("carreras?accion=listar");
            }
            case "nuevo" -> {
                request.setAttribute("vista", "/views/carreras/formulario_carrera.jsp");
                request.getRequestDispatcher("/plantilla.jsp").forward(request, response);
            }
            default -> response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idTexto = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String codigo = request.getParameter("codigo");
        String facultad = request.getParameter("facultad");
        String nivel = request.getParameter("nivel");
        String[] modalidadesArr = request.getParameterValues("modalidades");
        boolean estadoActiva = request.getParameter("estadoActiva") != null;
        String descripcion = request.getParameter("descripcion");

        List<String> modalidades = modalidadesArr != null ? Arrays.asList(modalidadesArr) : List.of();

        Carrera c = new Carrera(
                idTexto == null || idTexto.isBlank() ? 0 : Integer.parseInt(idTexto),
                nombre, codigo, facultad, nivel, modalidades, estadoActiva, descripcion
        );

        if (idTexto == null || idTexto.isBlank()) {
            service.registrar(c);
        } else {
            service.actualizar(c);
        }

        response.sendRedirect("carreras?accion=listar");
    }
}