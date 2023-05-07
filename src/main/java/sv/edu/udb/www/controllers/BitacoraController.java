package sv.edu.udb.www.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sv.edu.udb.www.beans.BitacorasBeans;
import sv.edu.udb.www.beans.CasosBeans;
import sv.edu.udb.www.models.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "BitacorasController", urlPatterns = {"/bitacoras.do"})
public class BitacoraController extends HttpServlet{
    ArrayList<String> listaErrores = new ArrayList<>();
    BitacorasModel bitacorasModelo = new BitacorasModel();
    protected  void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()){
            if(request.getParameter("op")==null){
                listar(request, response);
                return;
            }
            String operacion = request.getParameter("op");
            switch (operacion){
                case "listar":
                    listar(request, response);
                    break;
                case "crearBictacora":
                    crearBitacora(request, response);
                    break;

                case "editarBitacora":
                    System.out.println("Si dentra a mofificar bitacora");
                    editarBitacora(request, response);
                    break;

                case "updateBitacora":
                    updateBitacora(request, response);
                    break;

                default:
                    request.getRequestDispatcher("/error404.jsp").forward(request, response);
                    break;
            }
        }
    }

    //método para solo mostrar la información
    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            request.setAttribute("listarBitacoras", bitacorasModelo.listarBitacoras());
            request.getRequestDispatcher("/bitacoras/listaBitacora.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BitacoraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(BitacoraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BitacoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //crear
    private void crearBitacora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int estado = Integer.parseInt(request.getParameter("idEstado"));
        if (estado != 7){
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }else{
            try{
                BitacorasBeans bitacora = new BitacorasBeans();
                bitacora.setId_bitacora(Integer.parseInt(request.getParameter("idBic")));
                bitacora.setFecha_limite(request.getParameter("FechaBic"));
                bitacora.setId_caso(Integer.parseInt(request.getParameter("casoBic")));
                bitacora.setModificaciones(request.getParameter("modifiBic"));
                bitacora.setAvance(request.getParameter("avanceBic"));
                System.out.println(bitacora);
                if (bitacorasModelo.crearBitacora(bitacora) > 0){
                    request.getSession().setAttribute("éxito", "La bitacora se ha creado con éxito.");
                    response.sendRedirect(request.getContextPath() +"/bitacoras.do?op=listar");
                }else {
                    request.getSession().setAttribute("fracaso", "La bitacora no se pudo crear");
                    response.sendRedirect(request.getContextPath() + "/CasosController.do?op=mostrarCasosBic");
                }
            } catch (IOException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void editarBitacora(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            BitacorasBeans bitacoraBean = bitacorasModelo.obtenerBitacora(codigo);
            CasosBeans caso = new CasosBeans();
            System.out.println(bitacorasModelo);
            if(bitacoraBean != null){
                request.setAttribute("bitacora", bitacoraBean);
                request.setAttribute("casosBic", caso);
                request.getRequestDispatcher("/bitacoras/editarBitacora.jsp").forward(request, response);
            }else{
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }

        }catch (SQLException | ServletException | IOException ex) {
            //
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }
    }

    private void updateBitacora(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int estado = Integer.parseInt(request.getParameter("idEstado"));
        if (estado != 7){
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }else {
            try {
                BitacorasBeans bitacora = new BitacorasBeans();
                bitacora.setId_bitacora(Integer.parseInt(request.getParameter("idBic")));
                bitacora.setFecha_limite(request.getParameter("FechaBic"));
                bitacora.setId_caso(Integer.parseInt(request.getParameter("casoBic")));
                bitacora.setModificaciones(request.getParameter("modifiBic"));
                bitacora.setAvance(request.getParameter("avanceBic"));

                System.out.println(bitacora);

                if (bitacorasModelo.modificarBitacora(bitacora) > 0) {
                    if (bitacora.getAvance().equals("100")) {
                        System.out.println("La bitacora se ha creado con éxito y el avance ha llegado al 100%.");
                    } else {
                        request.getSession().setAttribute("mensaje", "La bitacora se ha creado con éxito.");
                    }
                    response.sendRedirect(request.getContextPath() + "/bitacoras.do?op=listar");
                } else {
                    request.getSession().setAttribute("fracaso", "La bitacora no se pudo crear");
                    response.sendRedirect(request.getContextPath() + "/bitacoras.do?op=listar");
                }
            } catch (IOException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //no tocar esta parte de codigo
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