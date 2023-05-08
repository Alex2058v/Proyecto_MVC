<%--
    Created by IntelliJ IDEA.
    User: AYALA
    Date: 8/5/2023
    Time: 11:39
    To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrador de usuarios</title>
    <jsp:include page="/cabecera.jsp"/>
</head>
<body>

<div class="container">
    <div class="row">
        <h2>Administrador de usuarios</h2>
    </div>

    <div class="col-lg-3 col-md-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="glyphicon glyphicon-user huge"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${requestScope.totalUsuarios}</div>
                        <div><h4>Usuarios.</h4></div>
                    </div>
                </div>
            </div>
            <a href="${pageContext.request.contextPath}/admin.do?op=listar">
                <div class="panel-footer">
                    <span class="pull-left">Ver casos usuarios registrados</span>
                    <span class="pull-right"><i class="glyphicon glyphicon-arrow-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
</div>

</body>
</html>
