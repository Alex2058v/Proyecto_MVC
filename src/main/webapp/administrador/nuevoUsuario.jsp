<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 8/5/2023
    Time: 13:14
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nuevo usuario</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <h3>Registro de nuevo Usuario</h3>
    </div>

    <form role="form" action="${contextPath}/admin.do" method="POST">
        <input type="hidden" name="op" value="insertar">

        <div class="form-group">
            <label for="nombre">Nombres:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="nombre"  id="nombre" value="${usuario.nombres}" placeholder="Nombre del usuario" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="apellidos">Apellidos:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="apellidos"  id="apellidos" value="${usuario.apellidos}" placeholder="Apellido del usuario" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="usuario">Usuario:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="usuario"  id="usuario" value="${usuario.usuario}" placeholder="Usuario" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="contrasenia">Contraseña:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="contrasenia"  id="contrasenia" value="${usuario.contrasenia}" placeholder="Contraseña para el usuario" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="tipoUsuario">Tipo del usuario:</label>
            <div class="input-group">
                <select name="tipoUsuario" id="tipoUsuario" class="form-control">
                    <c:forEach items="${requestScope.tipoUsuarios}" var="tipo">
                        <option value="${tipo.idtipousuario}">${tipo.tipousuario}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="departamento">Departamento del usuario</label>
            <div class="input-group">
                <select name="departamento" id="departamento" class="form-control">
                    <c:forEach items="${requestScope.departamentoUsuario}" var="depa">
                        <option value="${depa.iddepartamento}">${depa.departamento}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <input type="submit" class="btn btn-info" value="Guardar" name="Guardar">
        <a class="btn btn-danger" href="${contextPath}/admin.do?op=listar">Cancelar</a>
    </form>
</div>
</body>
</html>
