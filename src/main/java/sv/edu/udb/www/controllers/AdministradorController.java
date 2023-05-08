package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sv.edu.udb.www.beans.UsuariosBeans;
import sv.edu.udb.www.models.*;

@WebServlet(name = "AdministradorController", urlPatterns = {"/admin.do"})
public class AdministradorController extends HttpServlet{
    AdministradorModel admin = new AdministradorModel();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            if(request.getParameter("op")==null){
                mostrar(request, response);
                return;
            }
            String operacion = request.getParameter("op");
            switch (operacion) {
                case "listar":
                    listar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                case "nuevo":
                    nueva(request, response);
                    break;
                case "insertar":
                    insertar(request, response);
                    break;
            }
        }
    }
    private void mostrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            request.setAttribute("totalUsuarios", admin.totalUsuarios());
            request.getRequestDispatcher("administrador.jsp").forward(request, response);

        }catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(JefeDesarolloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            request.setAttribute("listarUsuarios", admin.listrarUsuarios());
            request.getRequestDispatcher("/administrador/usuarios.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        } catch (ServletException ex) {
            //Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            if (admin.eliminarUsuario(codigo) > 0){
                response.sendRedirect(request.getContextPath() + "/admin.do?op=listar");
            }else{
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void nueva(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("tipoUsuarios", admin.tipoUsuarios());
            request.setAttribute("departamentoUsuario", admin.departamento());
            request.getRequestDispatcher("/administrador/nuevoUsuario.jsp").forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    private void insertar(HttpServletRequest request, HttpServletResponse response){
        try {
            UsuariosBeans usuarios = new UsuariosBeans();
            usuarios.setNombres(request.getParameter("nombre"));
            usuarios.setApellidos(request.getParameter("apellidos"));
            usuarios.setUsuario(request.getParameter("usuario"));
            usuarios.setContrasenia(request.getParameter("contrasenia"));
            usuarios.setIdTipousuario(Integer.parseInt(request.getParameter("tipoUsuario")));
            usuarios.setIdDepartamento(Integer.parseInt(request.getParameter("departamento")));

            if(admin.ingresarUsuario(usuarios) > 0){
                response.sendRedirect(request.getContextPath() + "/admin.do?op=listar");
            }else {
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }
        } catch (IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
