<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
  <div class="container-fluid d-flex justify-content-between align-items-center">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">RAINDROPS</a>

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
                           <a class="nav-link" href="${pageContext.request.contextPath}/carrito.jsp">Mi carrito (${carro.carro.size()})</a>
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