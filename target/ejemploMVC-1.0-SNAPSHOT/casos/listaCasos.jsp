
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
        <h2>Lista de Casos</h2>
    </div>
    <div class="row">
        <a type="button" class="btn btn-primary btn-md"
           href="${contextPath}/casos.do?op=nuevo">
            Nuevo Caso</a>
    </div>

    <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
        <thead>
        <tr>
            <th>Código de caso</th>
            <th>Descripcion de caso</th>
            <th>Estado</th>
            <th>Operaciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.listarCasos}" var="casos">
            <tr>
                <td>${casos.id_caso}</td>
                <td>${casos.descripcion_caso}</td>
                <td>${casos.id_estado}</td>
                <td>
                    <a title="modificar" class="btn btn-primary"
                       href="${contextPath}/casos.do?op=obtener&id=${casos.id_caso}">
                        <span class="glyphicon glyphicon-edit"></span>
                    </a>

                    <a title="eliminar" class="btn btn-danger" onclick="eliminar(${casos.id_caso})">
                        <span class="glyphicon glyphicon-trash"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    function eliminar(id){
        alertify.confirm("¿Realmente desea eliminar este caso?", function (e){
            console.log(id)
            if(e){
                location.href = "casos.do?op=eliminar&id=" + id;
            }
        });
    }
</script>
</body>
</html>
