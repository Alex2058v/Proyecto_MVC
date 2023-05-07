<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file='/cabecera.jsp' %>
    <title>Modificar Casos</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h3>Modificar Caso</h3>
    </div>
    <form role="form" action="${contextPath}/casos.do" method="POST">
        <input type="hidden" name="op" value="modificar">
        <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>
        <div class="form-group">
            <label for="idCaso">Codigo de la venta:</label>
            <div class="input-group">
                <input type="text" class="form-control" name="idCaso"  id="idCaso" value="${casos.id_caso}" placeholder="Ingresa el codigo " >
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="DescripcionCaso">Descripcion del Caso:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="DescripcionCaso" id="DescripcionCaso" value="${casos.descripcion_caso}" placeholder="Descripcion breve del caso">
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="form-group">
            <label for="DescripcionCaso">Pdf:</label>
            <div class="input-group">
                <input required type="text" class="form-control" name="pdfcaso" id="pdfcaso" value="${casos.archivo_pdf}" placeholder="Descripcion breve del caso">
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
        </div>

        <div class="input-group">
            <label for="estadoCaso">Estado del Caso:</label>
            <div class="input-group">
                <select name="estadoCaso" id="estadoCaso" class="form-control">
                    <option value="3">Pendiente</option>
                </select>
            </div>
        </div>

        <input type="submit" class="btn btn-info" value="Guardar" name="Guardar">
        <a class="btn btn-danger" href="${contextPath}/casos.do?op=listar">Cancelar</a>
    </form>
</div>
</body>
</html>