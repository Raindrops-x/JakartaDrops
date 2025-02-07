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
    <jsp:include page="/layout/navbar.jsp"/>
    <div class="text-center">
        <h4>Carro de compras</h4>
        <h6>Compras del usuario ${usuario.nombre}</h6>
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
                    <th>Quitar</th>
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
                        <td><a href="${pageContext.request.contextPath}/carrito/quitar_celular?id=${l.celular.id}" class="btn btn-danger">X</a><td>
                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="4">Total de Venta</th>
                    <td>${carro.calcularTotalCarro()}</td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/carrito/vaciar_carrito" class="btn btn-danger">Vaciar Carro</a><td>
                </tr>
            </tbody>
        </table>
    </div>
<jsp:include page="layout/footer.jsp"/>