<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inicio de Sesión</title>
</head>
<body>
<form action="usuario" method="post">
    <table>
        <tr>
            <td>Usuario</td>
            <td><input type="text" name="usuario" id="usuario"/></td>
        </tr>
        <tr>
            <td>Clave</td>
            <td><input type="password" name="clave" id="clave" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Iniciar sesión"/></td>
        </tr>
    </table>
    <div>
        <p>
            <%
                String resultado = (String)request.getAttribute("mensaje");
                String mensaje = "";
                if (resultado != null) {
                    mensaje = resultado;
                }
            %>
            <%=mensaje %>
        </p>
    </div>
</form>
</body>
</html>