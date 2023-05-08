<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 8/5/2023
    Time: 12:17
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gestión de usuarios</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <h3>GESTIÓN DE CASOS USUARIOS.</h3>
    </div>

    <div class="row">
        <a type="button" class="btn btn-primary btn-md"
            href="${contextPath}/admin.do?op=nuevo">
            Nuevo registro de usuario.</a>
    </div>

    <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
        <thead>
            <tr>
                <td>Id usuario</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Usuario</td>
                <td>Tipo de usuario</td>
                <td>Departamento</td>
                <td>Acciones</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.listarUsuarios}" var="usuarios">
                <tr>
                    <td>${usuarios.id_usuario}</td>
                    <td>${usuarios.nombres}</td>
                    <td>${usuarios.apellidos}</td>
                    <td>${usuarios.usuario}</td>
                    <td>${usuarios.id_tipousuario}</td>
                    <td>${usuarios.id_departamento}</td>

                    <td>
                        <a title="Editar" class="btn btn-info"
                            href="${contextPath}/#">
                            <span class="glyphicon glyphicon-bitcoin"></span>
                        </a>
                        <a title="eliminar" class="btn btn-danger" onclick="eliminar(${usuarios.id_usuario})">
                            <span class="glyphicon glyphicon-trash"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script>
    function eliminar(id){
        alertify.confirm("¿Realmente desea eliminar este usuario?", function (e){
            console.log(id)
            if(e){
                location.href = "admin.do?op=eliminar&id=" + id;
            }
        });
    }
</script>
</html>
