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
<jsp:include page="/layout/navbar.jsp"/>
<div class="container">
    <div class="row text-center py-3">
        <h4>Hola mundo desde git y Jakarta</h4>
        <img src="https://cdn.shopify.com/s/files/1/0344/6469/files/cat-gif-loop-ice_grande.gif?v=1523984147" alt="Gif de gato" />
    </div>
</div>
<jsp:include page="layout/footer.jsp"/>
