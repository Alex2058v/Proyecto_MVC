<%--
  Created by IntelliJ IDEA.
  User: wilme
  Date: 6/5/2023
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Aprobar Caso</title>
  <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<div class="container">
  <div class="row">
    <h3 class="text-center">Crear bitacora.</h3>
  </div>

  <form role="form" action="${contextPath}/bitacoras.do" method="POST">
    <input type="hidden"  name="op" value="updateBitacora">
    <div class="input-group">
      <input readonly required type="text" class="form-control" name="idEstado"  id="idEstado" value="${casosBic.idEstado}" placeholder="Id_estado." >
    </div>

    <div class="form-group">
      <label for="idBic">Id Bitacora:</label>
      <div class="input-group">
        <input readonly type="text" class="form-control" name="idBic"  id="idBic" value="${bitacora.id_bitacora}"  placeholder="Fecha limite." >
        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
      </div>
    </div>

    <div class="form-group">
      <label for="FechaBic">Fecha limite:</label>
      <div class="input-group">
        <input readonly type="text" class="form-control" name="FechaBic"  id="FechaBic" value="${bitacora.fecha_limite}" placeholder="Fecha limite." >
        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
      </div>
    </div>

    <div class="form-group">
      <label for="casoBic">Caso</label>
      <div class="input-group">
        <input readonly type="text" class="form-control" name="casoBic"  id="casoBic" value="${bitacora.id_caso}" placeholder="Titulo del caso." >
        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
      </div>
    </div>

    <div class="form-group">
      <label for="modifiBic">Modificaciones:</label>
      <div class="input-group">
        <input  type="text" class="form-control" name="modifiBic"  id="modifiBic" value="${bitacora.modificaciones}" placeholder="Modificaciones." >
        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
      </div>
    </div>

    <div class="form-group">
      <label for="avanceBic">Avance:</label>
      <div class="input-group">
        <input  type="text" class="form-control" name="avanceBic"  id="avanceBic" value="${bitacora.avance}"  placeholder="Avance del programa." >
        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
      </div>
    </div>

    <input type="submit" class="btn btn-info" value="modificar" name="modificar">
    <a class="btn btn-danger" href="${contextPath}/bitacoras.do?op=listar">Cancelar</a>
  </form>
</div>
</body>
</html>