<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>${alumno != null ? "Editar Alumno" : "Nuevo Alumno"}</h2>

<form method="post" action="">
    <input type="hidden" name="accion" value="guardar" />
    <c:if test="${alumno != null}">
        <input type="hidden" name="id" value="${alumno.id}" />
    </c:if>

    <div class="mb-3">
        <label class="form-label">Nombre completo</label>
        <input type="text" name="nombre" class="form-control" required value="${alumno.nombre != null ? alumno.nombre : ''}" />
    </div>

    <div class="mb-3">
        <label class="form-label">Carrera</label>
        <input type="text" name="carrera" class="form-control" required value="${alumno.carrera != null ? alumno.carrera : ''}" />
    </div>

    <button type="submit" class="btn btn-success">Guardar</button>
    <a href="" class="btn btn-secondary">Cancelar</a>
</form>
