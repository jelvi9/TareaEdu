<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Listado de Carreras</h2>
<div class="mb-3">
    <a href="carreras?nuevo" class="btn btn-success">Nueva Carrera</a>
</div>

<table class="table table-striped table-bordered align-middle">
    <thead class="table-dark">
    <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Código</th>
        <th>Facultad</th>
        <th>Nivel</th>
        <th>Modalidades</th>
        <th>Activa</th>
        <th>Descripción</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${carreras}">
        <tr>
            <td>${c.id}</td>
            <td>${c.nombre}</td>
            <td>${c.codigo}</td>
            <td>${c.facultad}</td>
            <td>${c.nivel}</td>
            <td>
                <c:forEach var="m" items="${c.modalidades}" varStatus="st">
                    ${m}<c:if test="${!st.last}">, </c:if>
                </c:forEach>
            </td>
            <td>
                <c:choose>
                    <c:when test="${c.estadoActiva}">Sí</c:when>
                    <c:otherwise>No</c:otherwise>
                </c:choose>
            </td>
            <td>${c.descripcion}</td>
            <td>
                <a href="carreras?accion=editar&id=${c.id}" class="btn btn-sm btn-primary">Editar</a>
                <a href="carreras?accion=eliminar&id=${c.id}" class="btn btn-sm btn-danger"
                   onclick="return confirm('¿Eliminar esta carrera?');">Eliminar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>