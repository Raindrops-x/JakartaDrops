<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mi Carro</title>
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
    <div class="text-center">
        <h4>Carro de compras</h4>
        <h6>Compras del usuario ${nombre.nombre}</h6>
    </div>

    <div class="container d-flex justify-content-center py-3 my-3">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>SubTotal</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${carro.carro}" var="l">
                    <tr>
                        <th>${l.celular.id}</th>
                        <td>${l.celular.nombre}</td>
                        <td>${l.celular.precio}</td>
                        <td>${l.cantidad}</td>
                        <td>${l.calcularPrecio()}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="4">Total de Venta</th>
                    <td>${carro.calcularTotalCarro()}</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>