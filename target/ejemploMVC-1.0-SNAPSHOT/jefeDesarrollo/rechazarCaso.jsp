<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rechazar Caso</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<jsp:include page="/jefeDesarrollo/menuJefeDesarrollo.jsp"/>
<div class="container">
    <div class="row">
        <h3 class="text-center">Rechazar caso.</h3>
    </div>

    <form role="form" action="${contextPath}/casos.do" method="POST">
        <input type="hidden"  name="op" value="rechazarCaso">

        <div class="form-group">
            <label for="idCaso">Código del caso:</label>
            <div class="input-group">
                <input readonly type="text" class="form-control" name="idCaso"  id="idCaso" value="${casos.id_caso}" placeholder="Código del caso." >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <!--Código del estado que me servira para validar-->
        <div class="input-group">
            <input readonly type="hidden" class="form-control" name="idEstado"  id="idEstado" value="${casos.idEstado}" placeholder="Código del caso." >
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
        </div>

        <div class="form-group">
            <label for="argumento">Argumento del rechazo:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="argumento"  id="argumento" value="${casos.argumento}" placeholder="Argumento" >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <input type="submit" class="btn btn-info" value="Rechazar" name="Rechazar">
        <a class="btn btn-danger" href="${contextPath}casos.do?op=mostarCasos">Cancelar</a>
    </form>
</div>
</body>
</html>