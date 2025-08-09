<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Formulario de Carrera</h2>

<form method="post" action="" class="row g-3">
  <c:if test="${carrera != null}">
    <input type="hidden" name="id" value="${carrera.id}" />
  </c:if>

  <div class="col-md-6">
    <label class="form-label">Nombre de la carrera</label>
    <input type="text" name="nombre" class="form-control" required
           value="${carrera != null ? carrera.nombre : ''}"/>
  </div>

  <div class="col-md-3">
    <label class="form-label">Código</label>
    <input type="text" name="codigo" class="form-control" required
           value="${carrera != null ? carrera.codigo : ''}"/>
  </div>

  <div class="col-md-3">
    <label class="form-label">Facultad</label>
    <select name="facultad" class="form-select">
      <c:forEach var="fac" items="${['Ingeniería','Arquitectura','Ciencias Económicas','Humanidades']}">
        <option value="${fac}" <c:if test="${carrera != null && carrera.facultad == fac}">selected</c:if>>${fac}</option>
      </c:forEach>
    </select>
  </div>

  <div class="col-md-4">
    <label class="form-label">Nivel</label>
    <select name="nivel" class="form-select">
      <c:forEach var="n" items="${['Técnico','Licenciatura','Maestría']}">
        <option value="${n}" <c:if test="${carrera != null && carrera.nivel == n}">selected</c:if>>${n}</option>
      </c:forEach>
    </select>
  </div>

  <div class="col-md-8">
    <label class="form-label d-block">Modalidades</label>
    <c:set var="mods" value="${carrera != null ? carrera.modalidades : []}" />
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="checkbox" name="modalidades" value="Presencial"
             <c:if test="${mods contains 'Presencial'}">checked</c:if> />
      <label class="form-check-label">Presencial</label>
    </div>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="checkbox" name="modalidades" value="Virtual"
             <c:if test="${mods contains 'Virtual'}">checked</c:if> />
      <label class="form-check-label">Virtual</label>
    </div>
    <div class="form-check form-check-inline">
      <input class="form-check-input" type="checkbox" name="modalidades" value="Semipresencial"
             <c:if test="${mods contains 'Semipresencial'}">checked</c:if> />
      <label class="form-check-label">Semipresencial</label>
    </div>
  </div>

  <div class="col-md-4">
    <div class="form-check mt-4">
      <input class="form-check-input" type="checkbox" name="estadoActiva"
             <c:if test="${carrera != null && carrera.estadoActiva}">checked</c:if> />
      <label class="form-check-label">Carrera Activa</label>
    </div>
  </div>

  <div class="col-12">
    <label class="form-label">Descripción</label>
    <textarea name="descripcion" rows="3" class="form-control">${carrera != null ? carrera.descripcion : ''}</textarea>
  </div>

  <div class="col-12">
    <button class="btn btn-primary" type="submit">Guardar</button>
    <a class="btn btn-secondary" href="carreras?accion=listar">Ver lista</a>
  </div>
</form>