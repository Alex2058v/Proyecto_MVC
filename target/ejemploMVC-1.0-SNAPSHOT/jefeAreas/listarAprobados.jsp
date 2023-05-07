<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Casos</title>
    <%@ include file='/cabecera.jsp' %>
</head>
<body>
<div class="container">
    <div class="row">
        <h2>Lista de Casos Aprobados</h2>
    </div>

    <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
        <thead>
        <tr>
            <th>Id</th>
            <th>Codigo de Caso</th>
            <th>Descripcion de caso</th>
            <th>Archivo Pdf</th>
            <th>Estado</th>
            <th>Fecha Solicitud</th>
            <th>Fecha Limite</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.listaaprobados}" var="casos">
            <tr>
                <td>${casos.id_caso}</td>
                <td>${casos.cod_caso}</td>
                <td>${casos.descripcion_caso}</td>
                <th>${casos.archivo_pdf}</th>
                <td>${casos.id_estado}</td>
                <th>${casos.fecha_solicitud}</th>
                <th>${casos.fecha_limite}</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
