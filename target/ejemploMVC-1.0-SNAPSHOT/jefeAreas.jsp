<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Jefe de Area</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<jsp:include page="/jefeAreas/menuJefeAreas.jsp"/>
<div class="container">
    <div class="row">
        <h2>Jefe de Area</h2>
    </div>

    <div class="col-lg-3 col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="glyphicon glyphicon-list-alt"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${requestScope.totalCasos}</div>
                        <div><h4>Casos en espera</h4></div>
                    </div>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/casos.do?op=listar">
                <div class="panel-footer">
                    <span class="pull-left">Ver Casos</span>
                    <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>


    <div class="col-lg-3 col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="glyphicon glyphicon-ok"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${requestScope.totalAprobados}</div>
                        <div><h4>Casos Aprobados</h4></div>
                    </div>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/casos.do?op=listaraprobados">
                <div class="panel-footer">
                    <span class="pull-left">Ver Casos Aprobados</span>
                    <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>

    <div class="col-lg-3 col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="glyphicon glyphicon-remove"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${requestScope.totalrechazados}</div>
                        <div><h4>Casos Rechazados</h4></div>
                    </div>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/casos.do?op=listarrechazados">
                <div class="panel-footer">
                    <span class="pull-left">Ver Casos Aprobados</span>
                    <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
</div>
</body>
</html>