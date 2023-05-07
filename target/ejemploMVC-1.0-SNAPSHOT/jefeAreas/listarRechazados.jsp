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
        <h2>Lista de Casos Rechazados</h2>
    </div>

    <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
        <thead>
        <tr>
            <th>Id</th>
            <th>Descripcion de caso</th>
            <th>Archivo Pdf</th>
            <th>Argumento</th>
            <th>Estado</th>
            <th>Operaciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.listarechazados}" var="casos">
            <tr>
                <td>${casos.id_caso}</td>
                <td>${casos.descripcion_caso}</td>
                <th>${casos.archivo_pdf}</th>
                <th>${casos.argumento}</th>
                <td>${casos.id_estado}</td>
                <td>
                    <a title="modificar" class="btn btn-primary"
                       href="${contextPath}/casos.do?op=obtener&id=${casos.id_caso}">
                        <span class="glyphicon glyphicon-edit"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
