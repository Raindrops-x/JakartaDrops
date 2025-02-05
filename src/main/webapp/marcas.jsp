<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marcas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
  <div class="container-fluid d-flex justify-content-between align-items-center">
    <a class="navbar-brand" href="/JakartaDrops/index_logged.jsp">RAINDROPS</a>

    <div class="collapse navbar-collapse d-flex justify-content-between align-items-center" id="navbarNav">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/celulares.html">Celulares</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/marcas.html">Marcas</a>
        </li>
      </ul>

      <ul class="navbar-nav ms-auto">
        <c:if test="${empty usuario.nombre}">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Iniciar Sesion</a>
          </li>
        </c:if>
        <c:if test="${not empty usuario.nombre}">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout.html">Cerrar Sesion</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white">¡Hola ${usuario.nombre}!</a>
          </li>
        </c:if>
        <li class="nav-item">
          <button class="btn btn-danger" onclick="cerrarVentana();">Ø</button>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="d-flex justify-content-center py-3 my-3">
  <a class="text-black btn btn-success" href="/JakartaDrops/marcas/formulario">Registre Marca [+]!</a>
</div>
<div class="container py-3 my-3 rounded" style="background-color: gray;">
    <c:if test="${not empty error_delete}">
       <div class="alert alert-danger text-center" role="alert">
           <p>${error_login}</p>
       </div>
    </c:if>
  <div class="text-center">
  <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Marca</th>
        <c:if test="${not empty usuario.nombre}">
           <th>Editar<th>
           <th>Eliminar<th>
        </c:if>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${marcas}" var="m">
      <tr>
        <td>${m.id}</td>
        <td>${m.nombre}</td>
        <c:if test="${not empty usuario.nombre}">
            <td><a href="${pageContext.request.contextPath}/marcas/editar_marca?id=${m.id}" class="btn btn-warning">Ver</a><td>
            <td><a href="${pageContext.request.contextPath}/marcas/eliminar_marca?id=${m.id}" class="btn btn-danger">X</a><td>
        </c:if>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
  function cerrarVentana() {
      alert("Tu navegador no permite cerrar esta pestaña automáticamente. Ciérrala manualmente.");
  }
</script>
</body>
</html>