<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 7/5/2023
    Time: 20:37
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Asignar a un caso a un probador</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<jsp:include page="/jefeDesarrollo/menuJefeDesarrollo.jsp"/>

<div class="container">
    <div class="row">
        <h3>GESTIÓN DE CASOS POR APROBAR.</h3>
    </div>

    <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
        <thead>
            <tr>
                <th>ID del caso</th>
                <th>Título del caso</th>
                <th>Departamento</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.mostrarCasos}" var="casos">
                <tr>
                    <td>${casos.id_caso}</td>
                    <td>${casos.titulo_caso}</td>
                    <td>${casos.id_departamento}</td>

                    <td>
                        <a title="aprobar" class="btn btn-info"
                            href="${contextPath}/casos.do?op=obtenerCaso&id=${casos.id_caso}">
                            <span>Dar caso a un probador</span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</body>
</html>
