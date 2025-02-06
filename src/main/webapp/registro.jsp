<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/JakartaDrops/index.html">RAINDROPS</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/celulares.html">Celulares</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/marcas.html">Marcas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login.html">Iniciar Sesion</a>
                </li>
            </ul>
            <button class="btn btn-danger ms-auto" onclick="cerrarVentana();">Ø</button>
        </div>
    </div>
</nav>
    <div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
        <div class="card shadow-lg p-4" style="max-width: 500px; width: 100%;">
        <c:if test="${not empty errores}">
            <div class="alert alert-danger text-center" role="alert">
            <c:forEach items="${errores}" var="e">
               <p>${e}</p>
            </c:forEach>
            </div>
        </c:if>
            <h3 class="card-title text-center mb-4">Registrar Usuario</h3>
            <form action="${pageContext.request.contextPath}/registro" method="POST">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input class="form-control" type="text" name="nombre" id="nombre" required>
                </div>
                <div class="mb-3">
                    <label for="usuario_name" class="form-label">Nombre de Usuario:</label>
                    <input class="form-control" type="text" name="usuario_name" id="usuario_name" required>
                </div>
                <div class="mb-3">
                    <label for="usuario_pass" class="form-label">Contraseña:</label>
                    <input class="form-control" type="password" name="usuario_pass" id="usuario_pass" required>
                </div>
                <div class="mb-3">
                    <label for="pass_repeat" class="form-label">Repite Contraseña:</label>
                    <input class="form-control" type="password" name="pass_repeat" id="pass_repeat" required>
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-success w-100">Registrarme</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
