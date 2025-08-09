<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light flex-column p-3">
    <a class="navbar-brand mb-4" href="index.jsp">EduJSPApp</a>
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link" href="alumnos">Lista de Alumnos</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="alumnos?accion=nuevo">Nuevo Alumno</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="profesores">Registrar Profesor</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="profesores?accion=listar">Ver Profesores</a>
        </li>
    </ul>
</nav>
