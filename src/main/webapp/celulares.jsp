<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Celulares</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="/layout/navbar.jsp"/>
<div class="d-flex justify-content-center py-3 my-3">
  <a class="text-black btn btn-success" href="/JakartaDrops/celulares/formulario">Registre un celular [+]!</a>
</div>
<div class="container py-3 my-3 rounded" style="background-color: gray;">
  <div class="text-center">
  <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Fecha Lanzamiento</th>
        <th>Marca</th>
        <c:if test="${not empty usuario.nombre}">
           <th>Carrito<th>
           <th>Editar<th>
           <th>Eliminar<th>
        </c:if>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${celulares}" var="c">
      <tr>
        <td>${c.id}</td>
        <td>${c.nombre}</td>
        <td>${c.precio}</td>
        <td>${c.fechaLanzamiento}</td>
        <td>${c.marca.nombre}</td>
        <c:if test="${not empty usuario.nombre}">
           <td>
           <form action="${pageContext.request.contextPath}/carrito/agregar_celular" method="get">
               <input type="hidden" name="id" value="${c.id}">
               <input type="number" id="cantidad" name="cantidad">
               <button type="submit" class="btn btn-primary">Agregar</a>
           </form>
           <td>
           <td><a href="${pageContext.request.contextPath}/celulares/editar_celular?id=${c.id}" class="btn btn-warning">Ver</a><td>
           <td><a href="${pageContext.request.contextPath}/celulares/eliminar_celular?id=${c.id}" class="btn btn-danger">X</a><td>
        </c:if>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </div>
</div>
<jsp:include page="layout/footer.jsp"/>