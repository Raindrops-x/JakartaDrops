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
    <jsp:include page="/layout/navbar.jsp"/>
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
<jsp:include page="layout/footer.jsp"/>