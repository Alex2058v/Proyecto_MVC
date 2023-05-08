<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 7/5/2023
    Time: 22:54
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Caso a probador</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<jsp:include page="/jefeDesarrollo/menuJefeDesarrollo.jsp"/>
<div class="container">
    <div class="row">
        <h3>Asignar un caso a un probador.</h3>

        <form role="form" action="${contextPath}/casos.do" method="POST">
            <input type="hidden"  name="op" value="asignarCasoProbador">

            <div class="form-group">
                <label for="idCaso">Código del caso:</label>
                <div class="input-group">
                    <input readonly type="text" class="form-control" name="idCaso"  id="idCaso" value="${casoObtener.id_caso}" placeholder="Código del caso." >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="input-group">
                <input readonly type="hidden" class="form-control" name="idEstado"  id="idEstado" value="${casoObtener.idEstado}" placeholder="Código del caso." >
            </div>

            <div class="form-group">
                <label for="idTitulo">Titulo del caso:</label>
                <div class="input-group">
                    <input disabled type="text" class="form-control" name="idTitulo"  id="idTitulo" value="${casoObtener.titulo_caso}" placeholder="Titulo del caso." >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="form-group">
                <label for="departamento">Departamento:</label>
                <div class="input-group">
                    <input disabled type="text" class="form-control" name="departamento"  id="departamento" value="${casoObtener.id_departamento}" placeholder="Titulo del caso." >
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                </div>
            </div>

            <div class="form-group">
                <label for="probador">Probador:</label>
                <div class="input-group">
                    <select name="probador" id="probador" class="form-control">
                        <c:forEach items="${requestScope.listrarProbadores}" var="progra">
                            <option value="${progra.id_usuario}">${progra.nombres}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <input type="submit" class="btn btn-info" value="Aprobar" name="Aprobar">
            <a class="btn btn-danger" href="${contextPath}/casos.do?op=gestionProbador">Cancelar</a>
        </form>
    </div>
</div>
</body>
</html>
