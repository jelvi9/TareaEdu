<%--
  Created by IntelliJ IDEA.
  User: DarwinRuiz
  Date: 8/1/2025
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Formulario de Profesor</h2>

<form method="post" action="" class="row g-3">
  <c:if test="${profesor != null}">
    <input type="hidden" name="id" value="${profesor.id}" />
  </c:if>

  <div class="col-md-6">
    <label>Nombre:</label>
    <input type="text" name="nombre" class="form-control" required
           value="${profesor != null ? profesor.nombre : ''}" />
  </div>

  <div class="col-md-6">
    <label>Email:</label>
    <input type="email" name="email" class="form-control" required
           value="${profesor != null ? profesor.email : ''}" />
  </div>

  <div class="col-md-6">
    <label>Género:</label><br />
    <input type="radio" name="genero" value="Femenino"
           <c:if test="${profesor.genero == 'Femenino'}">checked</c:if> /> Femenino
    <input type="radio" name="genero" value="Masculino"
           <c:if test="${profesor.genero == 'Masculino'}">checked</c:if> /> Masculino
  </div>

  <div class="col-md-6">
    <label>Tiempo completo:</label><br />
    <input type="checkbox" name="tiempoCompleto"
           <c:if test="${profesor.tiempoCompleto}">checked</c:if> /> Sí
  </div>

  <div class="col-md-6">
    <label>Especialidad:</label>
    <select name="especialidad" class="form-select">
      <c:forEach var="esp" items="${['Matemática','Física','Informática','Química']}">
        <option value="${esp}" <c:if test="${profesor.especialidad == esp}">selected</c:if>>${esp}</option>
      </c:forEach>
    </select>
  </div>

  <div class="col-md-6">
    <label>Cursos asignados:</label>
    <select name="cursos" class="form-select" multiple size="4">
      <c:forEach var="curso" items="${['Álgebra','Programación','Estadística','Bases de Datos']}">
        <option value="${curso}"
                <c:if test="${profesor.cursosAsignados != null && profesor.cursosAsignados.contains(curso)}">selected</c:if>>
            ${curso}
        </option>
      </c:forEach>
    </select>
  </div>

  <div class="col-12">
    <label>Observaciones:</label>
    <textarea name="observaciones" class="form-control">${profesor != null ? profesor.observaciones : ''}</textarea>
  </div>

  <div class="col-md-6">
    <label>Fecha de ingreso:</label>
    <input type="date" name="fechaIngreso" class="form-control"
           value="${profesor != null ? profesor.fechaIngreso : ''}" />
  </div>

  <div class="col-12">
    <button type="submit" class="btn btn-success">Guardar</button>
    <a href="?accion=listar" class="btn btn-secondary">Cancelar</a>
  </div>
</form>