<%--
  Created by IntelliJ IDEA.
  User: wilme
  Date: 4/5/2023
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista de Bitacoras</title>
    <%@include file="/cabecera.jsp" %>
</head>
<body>

  <div class="container">
    <div class="row">
      <h2>Inventario de Bitacora</h2>
    </div>


    <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
      <thead>
        <tr>
          <th>Código de bitacora</th>
          <th>Fecha limite</th>
          <th>Caso</th>
          <th>Modificaciones</th>
          <th>Avance</th>
          <th>Operaciones</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${requestScope.listarBitacoras}" var="bitacora">
        <tr>
          <td>${bitacora.id_bitacora}</td>
          <td>${bitacora.fecha_limite}</td>
          <td>${bitacora.id_caso}</td>
          <td>${bitacora.modificaciones}</td>
          <td>${bitacora.avance}</td>
          <td>
            <a title="modificar" class="btn btn-primary" href="${pageContext.request.contextPath}/bitacoras.do?op=editarBitacora&id=${bitacora.id_bitacora}"><span class="glyphicon glyphicon-edit"></span></a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
<div class="container">
  <a title="Regresar" class="btn btn-primary" href="${pageContext.request.contextPath}/MenuBitacora.jsp"><span class="glyphicon glyphicon-chevron-left glyphicon-size lg"></span></a>
</div>
</body>
</html>
