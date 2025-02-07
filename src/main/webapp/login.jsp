<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body class="bg-light d-flex flex-column" style="min-height: 100vh">
    <jsp:include page="/layout/navbar.jsp"/>
    <div class="container d-flex justify-content-center align-items-center flex-grow-1" style="padding-top: 40px;">
        <div class="card p-4 shadow-lg" style="max-width: 400px; width: 100%;">
            <div class="col-12 col-md-12">
                <h4 class="text-center mb-4">Formulario de inicio de sesión</h4>

                    <c:if test="${not empty error_login}">
                       <div class="alert alert-danger text-center" role="alert">
                          <p>${error_login}</p>
                       </div>
                    </c:if>
                    <c:if test="${not empty sugerencia}">
                       <div class="card bg-success text-center" role="alert">
                          <p>${sugerencia}</p>
                       </div>
                    </c:if>

                    <form action="/JakartaDrops/login" method="post">
                        <div class="form-group mb-3">
                            <label class="form-label" for="username">Usuario:</label>
                            <input type="text" class="form-control" name="username" id="username" placeholder="Ingrese su usuario">
                        </div>
                        <div class="form-group mb-3">
                            <label for="password">Contraseña:</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="Ingrese su contraseña">
                        </div>
                        <div class="d-flex justify-content-center gap-3">
                                <input type="submit" class="btn btn-success btn-lg" name="ingresar" value="Iniciar Sesión">
                                <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/registro">Registrar Usuario</a>
                        </div>
                    </form>
            </div>
        </div>
    </div>
<jsp:include page="layout/footer.jsp"/>