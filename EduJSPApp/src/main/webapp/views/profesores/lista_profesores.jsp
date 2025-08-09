<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Listado de Profesores</h2>

<table class="table table-striped table-bordered">
    <thead class="table-dark">
    <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Email</th>
        <th>Género</th>
        <th>Especialidad</th>
        <th>Cursos</th>
        <th>Tiempo Completo</th>
        <th>Fecha Ingreso</th>
        <th>Observaciones</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${profesores}">
        <tr>
            <td>${p.id}</td>
            <td>${p.nombre}</td>
            <td>${p.email}</td>
            <td>${p.genero}</td>
            <td>${p.especialidad}</td>
            <td>
                <ul class="mb-0">
                    <c:forEach var="c" items="${p.cursosAsignados}">
                        <li>${c}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <c:choose>
                    <c:when test="${p.tiempoCompleto}">Sí</c:when>
                    <c:otherwise>No</c:otherwise>
                </c:choose>
            </td>
            <td>${p.fechaIngreso}</td>
            <td>${p.observaciones}</td>
            <td>
                <a href="?accion=editar&id=${p.id}" class="btn btn-sm btn-primary">Editar</a>
                <a href="?accion=eliminar&id=${p.id}" class="btn btn-sm btn-danger"
                   onclick="return confirm('¿Eliminar este profesor?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>