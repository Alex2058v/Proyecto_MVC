<%--
  Created by IntelliJ IDEA.
  User: wilme
  Date: 6/5/2023
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creación de bitácora</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <h3 class="text-center">Crear bitácora.</h3>
    </div>

    <form role="form" action="${contextPath}/bitacoras.do" method="POST">
        <input type="hidden"  name="op" value="crearBictacora">

        <div class="form-group">
            <label for="idBic">Id bitácora:</label>
            <div class="input-group">
                <input  required type="text" class="form-control" name="idBic"  id="idBic"  placeholder="id bitacora." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="tituloCaso">Titulo del caso:</label>
            <div class="input-group">
                <input disabled type="text" class="form-control" name="tituloCaso"  id="tituloCaso" value="${casosBic.titulo_caso}"  placeholder="Titulo caso.">
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="FechaBic">Fecha limite:</label>
            <div class="input-group">
                <input readonly required type="text" class="form-control" name="FechaBic"  id="FechaBic" value="${casosBic.fecha_limite}" placeholder="Fecha limite." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="input-group">
            <input readonly required type="text" class="form-control" name="idEstado"  id="idEstado" value="${casosBic.idEstado}" placeholder="Id_estado." >
        </div>

        <div class="form-group">
            <label for="casoBic">Caso</label>
            <div class="input-group">
                <input readonly type="text" class="form-control" name="casoBic"  id="casoBic" value="${casosBic.id_caso}" placeholder="Titulo del caso." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="modifiBic">Modificaciones:</label>
            <div class="input-group">
                <input  type="text" class="form-control" name="modifiBic"  id="modifiBic" placeholder="Modificaciones." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="avanceBic">Avance:</label>
            <div class="input-group">
                <input  type="text" class="form-control" name="avanceBic"  id="avanceBic"  placeholder="Avance del programa." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <input type="submit" class="btn btn-info" value="Crear" name="Crear">
        <a class="btn btn-danger" href="${contextPath}/CasosController.do?op=mostarCasos">Cancelar</a>
    </form>
</div>
</body>
</html>