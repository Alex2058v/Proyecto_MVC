<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Aprobar Caso</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<jsp:include page="/jefeDesarrollo/menuJefeDesarrollo.jsp"/>
<div class="container">
    <div class="row">
        <h3 class="text-center">Aprobar Caso.</h3>
    </div>

    <form role="form" action="${contextPath}/casos.do" method="POST">
        <input type="hidden"  name="op" value="aprobarCaso">

        <div class="form-group">
            <label for="idCaso">Código del caso:</label>
            <div class="input-group">
                <input readonly type="text" class="form-control" name="idCaso"  id="idCaso" value="${casos.id_caso}" placeholder="Código del caso." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>
        <div class="form-group">
            <label for="idTitulo">Titulo del caso:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="idTitulo"  id="idTitulo" value="${casos.titulo_caso}" placeholder="Titulo del caso." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="idDescipcion">Descripción del caso</label>
            <div class="input-group">
                <input readonly type="text" class="form-control" name="idDescipcion"  id="idDescipcion" value="${casos.descripcion_caso}" placeholder="Titulo del caso." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="archivoPDF">Archivo pdf:</label>
            <div class="input-group">
                <input readonly type="text" class="form-control" name="archivoPDF"  id="archivoPDF" value="${casos.archivo_pdf }" placeholder="Archivo pdf." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>z

        <input type="submit" class="btn btn-info" value="Aprobar" name="Aprobar">
        <a class="btn btn-danger" href="${contextPath}/casos.do?op=mostarCasos">Cancelar</a>
    </form>
</div>
</body>
</html>