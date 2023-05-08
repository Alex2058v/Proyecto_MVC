
<html>
<head>
  <title>Lista de Bitacoras</title>
  <%@include file="/cabecera.jsp" %>
</head>
<body>

<div class="container">
  <div class="row">
    <h2>Casos Disponibles</h2>
  </div>

  <table class="table table-striped table-bordered table-hover" id="tabla" style="margin-top: 3rem">
    <thead>
    <tr>
      <th>Código de caso</th>
      <th>Titulo</th>
      <th>Descripcion</th>
      <th>Fecha limite</th>
      <th>Operaciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.mostarCasosBic}" var="casoBic">
      <tr>
        <td>${casoBic.id_caso}</td>
        <td>${casoBic.titulo_caso}</td>
        <td>${casoBic.descripcion_caso}</td>
        <td>${casoBic.fecha_limite}</td>
        <td>
          <div class="row">
            <a type="button" href="${pageContext.request.contextPath}/casos.do?op=obtenerCasoBic&id=${casoBic.id_caso}" class="btn btn-primary" > Crear Bitacora.</a>
          </div>
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
