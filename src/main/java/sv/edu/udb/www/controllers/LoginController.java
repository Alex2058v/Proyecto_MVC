package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sv.edu.udb.www.beans.UsuariosBeans;
import sv.edu.udb.www.models.Conexion;
import sv.edu.udb.www.models.UsuariosModel;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UsuariosModel usuarioModel = new UsuariosModel();
    private final Conexion conexion = new Conexion();

    public LoginController() throws SQLException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");

        try {
            conexion.conectar();
            UsuariosBeans user = usuarioModel.validarUsuario(usuario, contrasenia);
            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", user);

                switch (user.getIdTipousuario()) {
                    case 1: // Administrador
                        response.sendRedirect("AdministradorMenu.jsp");
                        break;
                    case 2: // Usuario normal
                        response.sendRedirect("JefaturaMenu.jsp");
                        break;
                        case 3:
                            response.sendRedirect("principal.jsp");
                    default:
                        response.sendRedirect("error.jsp");
                        break;
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
