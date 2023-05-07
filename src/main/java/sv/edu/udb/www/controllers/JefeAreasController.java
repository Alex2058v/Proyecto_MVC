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
import sv.edu.udb.www.models.*;

@WebServlet(name = "JefeAreasController", urlPatterns = {"/JefeAreas.do"})
public class JefeAreasController extends HttpServlet{

    JefeAreasModel jefeareasmodelo=new JefeAreasModel();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            if(request.getParameter("op")==null){
                mostrar(request, response);
                return;
            }
        }
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("totalCasos", jefeareasmodelo.totalCasos());
            request.setAttribute("totalAprobados", jefeareasmodelo.totalAprobados());
            request.setAttribute("totalrechazados", jefeareasmodelo.totalrechazados());
            request.getRequestDispatcher("jefeAreas.jsp").forward(request, response);

        }catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(JefeDesarolloController.class.getName()).log(Level.SEVERE, null, ex);
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
