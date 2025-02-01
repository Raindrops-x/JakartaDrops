<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
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
<div class="container">
    <div class="row text-center py-3">
        <h4>Hola mundo desde git y Jakarta</h4>
        <img src="https://cdn.shopify.com/s/files/1/0344/6469/files/cat-gif-loop-ice_grande.gif?v=1523984147" alt="Gif de gato" />
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
