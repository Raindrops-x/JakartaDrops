<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Celulares</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
  <jsp:include page="/layout/navbar.jsp"/>
  <div class="container my-3">
    <c:if test="${errores != null}">
        <div class="card bg-danger text-center">
        <c:forEach items="${errores}" var="e">
            <p>${e}</p>
        </c:forEach>
        </div>
    </c:if>
    <form action="/JakartaDrops/celulares/celular_form" class="form card form-card" method="post">
      <input type="hidden" name="id" id="id" value="${marca.id}">
      <div class="form-group mb-1">
        <label for="nombre_celular">Nombre de celular:</label>
        <input type="text" class="form-control" name="nombre_celular" id="nombre_celular" value="${celular.nombre}" placeholder="Ingrese el celular" required>
      </div>
      <div class="form-group mb-1">
        <label for="precio">Precio de celular:</label>
        <input type="number" class="form-control" name="precio" id="precio" value="${celular.precio}" placeholder="Ingrese el precio" required>
      </div>
      <div class="form-group mb-1">
        <label for="fecha">Fecha de celular:</label>
        <input type="date" class="form-control" name="fecha" id="fecha" value="${celular.fechaLanzamiento}" placeholder="Ingrese el precio" required>
      </div>
      <div class="form-group mb-1">
        <label for="marca">Nombre de celular:</label>
        <select class="form-select" name="marca" id="marca">
          <option value="">--Seleccione una marca---</option>
          <c:forEach items="${marcas}" var="m">
            <option value="${m.id}" ${m.id == celular.marca.id ? 'selected': ''}>${m.nombre}</option>
          </c:forEach>
        </select>
      </div>
      <div class="d-flex justify-content-center py-3">
        <input class="btn btn-success " type="submit" value="Registrar">
      </div>
    </form>
  </div>
<jsp:include page="layout/footer.jsp"/>