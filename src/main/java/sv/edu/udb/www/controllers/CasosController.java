package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import sv.edu.udb.www.beans.*;
import sv.edu.udb.www.models.*;

@WebServlet(name = "CasosController", urlPatterns = {"/casos.do"})
public class CasosController extends HttpServlet {
    //Parte de Javier Vasquez
    ArrayList<String> listaErrores = new ArrayList<>();
    CasosModel casosModelo = new CasosModel();
    EstadosModel estadosModelo = new EstadosModel();
    DepartamentoModel departamentoModelo = new DepartamentoModel();
    UsuariosModel usuarios = new UsuariosModel();
    CasosModel casosbic = new CasosModel();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("op") == null) {
                listar(request, response);
                return;
            }
            String operacion = request.getParameter("op");
            switch (operacion) {
                //JAVIER VASQUEZ
                case "listar":
                    listar(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                case "obtener":
                    obtener(request, response);
                    break;
                case "modificar":
                    modificar(request, response);
                    break;
                case "nuevo":
                    nueva(request, response);
                    break;
                case "insertar":
                    insertar(request, response);
                    break;
                case "listaraprobados":
                    listaraprobados(request, response);
                    break;
                case "listarrechazados":
                     listarrechazados(request, response);
                     break;

                    //ALEXANDER AYALA
                case "mostarCasos":
                    mostarCasos(request, response);
                    break;
                case "obtenerCaso":
                    obtenerCaso(request, response);
                    break;
                case "aprobarCaso":
                    aprobarCaso(request, response);
                    break;
                case "rechazarCaso":
                    rechazarCaso(request, response);
                    break;

                case "gestionProgramadores":
                    gestionProgramadores(request, response);
                    break;
                case "casoObtener":
                    casoObtener(request, response);
                    break;
                case "asignarCaso":
                    asignarCaso(request, response);
                    break;

                case "gestionProbador":
                    casosProbador(request, response);
                    break;

                    //PARTE DE WILMER
                case "mostrarCasosBic":
                    mostarCasosBic(request, response);
                    break;
                case "obtenerCasoBic":
                    obtenercasoBic(request, response);
                    break;
                default:
                    request.getRequestDispatcher("/error404.jsp").forward(request, response);
                    break;
            }
        }
    }




    //JAVIER VASQUEZ
    //Metodo para listar la informacion de la tabla

    private void listarrechazados(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("listarechazados", casosModelo.listarechazados());
            request.getRequestDispatcher("/jefeAreas/listarRechazados.jsp").forward(request,response);
        }catch (SQLException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaraprobados(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("listaaprobados", casosModelo.listaaprobados());
            request.getRequestDispatcher("/jefeAreas/listarAprobados.jsp").forward(request,response);
        }catch (SQLException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void listar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("listarCasos", casosModelo.listarCasos());
            request.getRequestDispatcher("/jefeAreas/listaCasos.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    //Para eliminar
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            if (casosModelo.eliminarCaso(codigo) > 0) {
                response.sendRedirect(request.getContextPath() + "/casos.do?op=listar");
            } else {
                request.setAttribute("fracaso", "No se puede eliminar este caso");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Metodo que obtiene los datos
    private void obtener(HttpServletRequest request, HttpServletResponse response) {
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            CasosBeans casos = casosModelo.obtenerCasos(codigo);
            if (casos != null) {
                request.setAttribute("casos", casos);
                request.setAttribute("listaEstados", estadosModelo.listaEstados());
                request.getRequestDispatcher("/jefeAreas/editarCasos.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }
        } catch (SQLException | ServletException | IOException ex) {
            //
        }
    }

    //Metodo para modificar
    private void modificar(HttpServletRequest request, HttpServletResponse response) {
        try {
            CasosBeans casos = new CasosBeans();
            System.out.println("id caso: " + request.getParameter("idCaso"));
            System.out.println("descripcion caso: " + request.getParameter("DescripcionCaso"));
            System.out.println("id_estado " + request.getParameter("estadoCaso"));

            casos.setId_caso(Integer.parseInt(request.getParameter("idCaso")));
            casos.setDescripcion_caso(request.getParameter("DescripcionCaso"));
            casos.setArchivo_pdf(request.getParameter("pdfcaso"));
            casos.setIdEstado(Integer.parseInt(request.getParameter("estadoCaso")));

            if (casosModelo.modificarCaso(casos) >= 0) {
                request.getSession().setAttribute("exito", "Caso Modificado Exitosamente");
                response.sendRedirect(request.getContextPath() + "/casos.do?op=listar");
                System.out.println("Entro al if");
            } else {
                request.getSession().setAttribute("fracaso", "El caso no a sido Modificado");
                response.sendRedirect(request.getContextPath() + "/casos.do?op=listar");
                System.out.println("No sirve :c");
            }
        } catch (IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodos para ingresar un nuevo caso
    private void nueva(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("listaEstados", estadosModelo.listaEstados());
            request.getRequestDispatcher("/jefeAreas/nuevoCaso.jsp").forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertar(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("funciona el insertar");
        try {
            CasosBeans casos = new CasosBeans();
            casos.setId_caso(Integer.parseInt(request.getParameter("idCaso"))); //El como se llaman en la vista
            casos.setDescripcion_caso(request.getParameter("DescripcionCaso"));
            casos.setArchivo_pdf(request.getParameter("pdfcaso"));
            casos.setIdEstado(Integer.parseInt(request.getParameter("estadoCaso")));


            System.out.println("id caso: " + request.getParameter("idCaso"));
            System.out.println("descripcion caso: " + request.getParameter("DescripcionCaso"));
            System.out.println("id_estado " + request.getParameter("estadoCaso"));
            System.out.println("Archivo_pdf: " + request.getParameter("pdfcaso"));

            if (casosModelo.ingresarCasos(casos) > 0) {
                request.getSession().setAttribute("exito", "Caso Ingresado Exitosamente");
                response.sendRedirect(request.getContextPath() + "/casos.do?op=listar");
                System.out.println("Entro al if");
            } else {
                request.getSession().setAttribute("fracaso", "El caso no a ingresado ya hay un caso con este id");
                response.sendRedirect(request.getContextPath() + "/casos.do?op=listar");
                System.out.println("No sirve :c");
            }
        } catch (IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ALEXANDER AYALA
    private void mostarCasos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("mostrarCasos", casosModelo.mostrarCasos());
            request.getRequestDispatcher("/jefeDesarrollo/gestionCasos.jsp").forward(request,response);
        } catch (SQLException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (IOException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        }
    }

    private void obtenerCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            int cod = Integer.parseInt(request.getParameter("c"));
            CasosBeans casosBean = casosModelo.obtenerCaso(codigo);
            if(cod == 1){
                if(casosBean != null){
                    request.setAttribute("casos", casosBean);
                    request.getRequestDispatcher("/jefeDesarrollo/aprobarCaso.jsp").forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath() + "/error404.jsp");
                }
            }
            else if(cod == 2){
                if(casosBean != null){
                    request.setAttribute("casos", casosBean);
                    request.getRequestDispatcher("/jefeDesarrollo/rechazarCaso.jsp").forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath() + "/error404.jsp");
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }
        }catch (SQLException | ServletException | IOException ex) {
            //
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }
    }
    private void aprobarCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int estado = Integer.parseInt(request.getParameter("idEstado"));
        if(estado != 3){
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }else{
            try {
                CasosBeans caso = new CasosBeans();
                caso.setId_caso(Integer.parseInt(request.getParameter("idCaso")));
                caso.setTitulo_caso(request.getParameter("idTitulo"));
                caso.setDescripcion_caso(request.getParameter("idDescipcion"));
                caso.setArchivo_pdf(request.getParameter("archivoPDF"));

                if (casosModelo.aprobarCaso(caso) > 0){
                    request.getSession().setAttribute("éxito", "El caso se ha aprobado con éxito.");
                    response.sendRedirect(request.getContextPath() +"/CasosController.do?op=mostarCasos");
                }else {
                    request.getSession().setAttribute("fracaso", "El caso no se pudo aprobar");
                    response.sendRedirect(request.getContextPath() + "/CasosController.do?op=mostarCasos");
                }
            }catch (IOException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void rechazarCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int estado = Integer.parseInt(request.getParameter("idEstado"));
        if(estado != 3){
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }else{
            try {
                CasosBeans caso = new CasosBeans();
                caso.setId_caso(Integer.parseInt(request.getParameter("idCaso")));
                caso.setDescripcion_caso(request.getParameter("idDescipcion"));
                caso.setArchivo_pdf(request.getParameter("archivoPDF"));
                caso.setArgumento(request.getParameter("argumento"));
                if (casosModelo.rechazarCaso(caso) > 0){
                    request.getSession().setAttribute("éxito", "El caso se ha rechazado con éxito.");
                    response.sendRedirect(request.getContextPath() +"/casos.do?op=mostarCasos");
                }else {
                    request.getSession().setAttribute("fracaso", "El caso no se pudo rechazar");
                    response.sendRedirect(request.getContextPath() + "/casos.do?op=mostarCasos");
                }
            }catch (IOException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    //A partir de aquí será para el punto 3, osea el de darle los casos a los programadores
    private void gestionProgramadores(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            request.setAttribute("casosProgramadores", casosModelo.casosProgramadores());
            request.getRequestDispatcher("/jefeDesarrollo/gestionProgramadores.jsp").forward(request,response);
        } catch (SQLException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (IOException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        }
    }
    private void casoObtener(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            CasosBeans casosBean = casosModelo.casoObtener(codigo);
            if(casosBean != null){
                request.setAttribute("casoObtener", casosBean);
                request.setAttribute("listaProgramadores", usuarios.mostrarUsuarios());
                request.getRequestDispatcher("/jefeDesarrollo/asignarProgramador.jsp").forward(request, response);
            }else{
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }
        }catch (SQLException | ServletException | IOException ex) {
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }
    }

    private void asignarCaso(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            CasosBeans caso = new CasosBeans();
            caso.setId_caso(Integer.parseInt(request.getParameter("idCaso")));
            caso.setIdProgramador(Integer.parseInt(request.getParameter("programador")));
            caso.setFecha_solicitud(request.getParameter("fechaSolicitud"));
            caso.setFecha_limite(request.getParameter("fechaLimite"));
            if (casosModelo.casoAsignado(caso) > 0){
                request.getSession().setAttribute("éxito", "El caso se ha aprobado con éxito.");
                response.sendRedirect(request.getContextPath() +"/CasosController.do?op=gestionProgramadores");
            }else {
                request.getSession().setAttribute("fracaso", "El caso no se pudo aprobar");
                response.sendRedirect(request.getContextPath() + "/CasosController.do?op=gestionProgramadores");
            }
        }catch (IOException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(LibrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void casosProbador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("mostrarCasos", casosModelo.mostrarCasoProbador());
            request.getRequestDispatcher("/jefeDesarrollo/asignarProbador.jsp").forward(request,response);
        }catch (SQLException ex) {
            Logger.getLogger(BitacoraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(BitacoraController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BitacoraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PARTE QUE UTILIZA WILMER
    private void mostarCasosBic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("mostarCasosBic", casosModelo.mostrarCasosBic());
            request.getRequestDispatcher("/bitacoras/listaCaso.jsp").forward(request,response);
        } catch (SQLException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        } catch (IOException ex) {
            response.sendRedirect("error404.jsp");
            ex.printStackTrace();
        }
    }

    private void obtenercasoBic(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            int codigo = Integer.parseInt(request.getParameter("id"));
            CasosBeans casoBicBean = casosbic.obtenerCasoBic(codigo);
            System.out.println(casosbic);
            if(casoBicBean != null){
                request.setAttribute("casosBic", casoBicBean);
                request.getRequestDispatcher("/bitacoras/crearBitacora.jsp").forward(request, response);
            }else{
                response.sendRedirect(request.getContextPath() + "/error404.jsp");
            }

        }catch (SQLException | ServletException | IOException ex) {
            //
            response.sendRedirect(request.getContextPath() + "/error404.jsp");
        }
    }


    //manejan las solicitudes HTTP GET y POST
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












































