<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Marcas</title>
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
                               <a class="nav-link" href="${pageContext.request.contextPath}/carrito.jsp">Mi carrito</a>
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
    <c:if test="${error_form_marca != null}">
        <p>${error_form_marca}</p>
    </c:if>
    <div class="container d-flex justify-content-center align-items-center" style="height: 100vh;">
        <form class="card p-4" action="/JakartaDrops/marcas/formulario" method="post">
            <input type="hidden" name="id" id="id" value="${marca.id}">
            <div class="form-group mb-1">
                <label for="nombre_marca">Nombre de Marca:</label>
                <input type="text" class="form-control" name="nombre_marca" id="nombre_marca" value="${marca.nombre}" placeholder="Ingrese la marca" required>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>

</body>
</html>