<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inicio</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <h1 class="text-center">Bitacora</h1>
    </div>


    <div class="row">

        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading text-centers">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="glyphicon glyphicon-book huge"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${requestScope.totalBitacoras}</div>
                            <div><h4>Casos Disponibles</h4></div>
                        </div>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/CasosController.do?op=mostrarCasosBic">
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
                <div class="panel-heading text-centers">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="glyphicon glyphicon-book huge"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">${requestScope.totalBitacoras}</div>
                            <div><h4>Bitacoras</h4></div>
                        </div>
                    </div>
                </div>
                <a href="${pageContext.request.contextPath}/bitacoras.do?op=listar">
                    <div class="panel-footer">
                        <span class="pull-left">Ver Bitacoras</span>
                        <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
    </div>

</div>
</body>
</html>