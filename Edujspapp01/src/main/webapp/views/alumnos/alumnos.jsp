<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Listado de Alumnos</h2>
<table class="table table-striped table-bordered">
    <thead class="table-dark">
    <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Carrera</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="a" items="${alumnos}">
        <tr>
            <td>${a.id}</td>
            <td>${a.nombre}</td>
            <td>${a.carrera}</td>
            <td>
                <a href="?accion=editar&id=${a.id}" class="btn btn-sm btn-primary">Editar</a>
                <a href="?accion=eliminar&id=${a.id}" class="btn btn-sm btn-danger" onclick="return confirm('¿Eliminar alumno?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>