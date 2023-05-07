package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.beans.*;

public class CasosModel extends Conexion{
    ///JAVIER VASQUEZ
    public List<CasosBeans> listarCasos() throws SQLException{
        try{
            List<CasosBeans> lista=new ArrayList<>();
            String sql = "SELECT casos.id_caso, casos.descripcion_caso, estado.estado, casos.archivo_pdf, departamento.departamento FROM casos INNER JOIN estado ON casos.id_estado = estado.id_estado INNER JOIN departamento ON casos.id_departamento = departamento.id_departamento WHERE estado.id_estado=3";
            this.conectar();
            cs = conexion.prepareCall(sql);
            rs=cs.executeQuery();
            while(rs.next()){
                CasosBeans casos=new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                casos.setId_estado(rs.getString("estado"));
                lista.add(casos);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            Logger.getLogger(CasosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return  null;
        }
    }

    public List<CasosBeans> listarechazados()throws SQLException{
        try{
            List<CasosBeans> lista=new ArrayList<>();
            String sql = "SELECT casos.id_caso, casos.descripcion_caso, estado.estado, casos.archivo_pdf, casos.argumento FROM casos INNER JOIN estado ON casos.id_estado = estado.id_estado INNER JOIN departamento ON casos.id_departamento = departamento.id_departamento WHERE estado.id_estado=4";
            this.conectar();
            cs = conexion.prepareCall(sql);
            rs=cs.executeQuery();
            while (rs.next()){
                CasosBeans casos=new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                casos.setArchivo_pdf(rs.getString("archivo_pdf"));
                casos.setArgumento(rs.getString("argumento"));
                casos.setId_estado(rs.getString("estado"));
                lista.add(casos);
            }this.desconectar();
            return lista;
        }catch (SQLException ex) {
            Logger.getLogger(CasosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return  null;
        }
    }

    public List<CasosBeans> listaaprobados()throws SQLException{
        try{
            List<CasosBeans> lista=new ArrayList<>();
            String sql = "SELECT casos.id_caso, casos.descripcion_caso, estado.estado, casos.archivo_pdf, casos.fecha_solicitud, casos.fecha_limite FROM casos INNER JOIN estado ON casos.id_estado = estado.id_estado INNER JOIN departamento ON casos.id_departamento = departamento.id_departamento WHERE estado.id_estado=5";
            this.conectar();
            cs = conexion.prepareCall(sql);
            rs=cs.executeQuery();
            while (rs.next()){
                CasosBeans casos=new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setCod_caso(rs.getString("Cod_caso"));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                casos.setArchivo_pdf(rs.getString("archivo_pdf"));
                casos.setId_estado(rs.getString("estado"));
                casos.setFecha_solicitud(rs.getString("fecha_solicitud"));
                casos.setFecha_limite(rs.getString("fecha_limite"));
                lista.add(casos);
            }this.desconectar();
            return lista;
        }catch (SQLException ex) {
            Logger.getLogger(CasosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return  null;
        }
    }

    public int eliminarCaso(int id)throws SQLException{
        try{
            int filasAfectadas=0;
            String sql="Delete from casos where id_caso=?";
            this.conectar();
            cs=conexion.prepareCall(sql);
            cs.setInt(1, id);
            filasAfectadas = cs.executeUpdate();
            return filasAfectadas;
        }catch (SQLException e) {
            this.desconectar();
            return 0;
        }
    }


    public int modificarCaso(CasosBeans casos) throws SQLException {
        try {
            int filasAfectadas = 0;
            String sql = "update casos set descripcion_caso=? , id_estado=?, id_programador=null , id_probador=null, archivo_pdf=? ,titulo_caso=null, fecha_solicitud=null, fecha_limite=null, observaciones=null, id_departamento=null  where id_caso=?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, casos.getDescripcion_caso());
            st.setInt(2, casos.getIdEstado());
            st.setString(3, casos.getArchivo_pdf());
            st.setInt(4, casos.getId_caso());
            filasAfectadas = st.executeUpdate();
            System.out.println(st.executeUpdate());
            System.out.println(filasAfectadas);
            this.desconectar();
            return filasAfectadas;
        } catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }

    public int ingresarCasos(CasosBeans casos) throws SQLException{
        try{
            int filasafectadas=0;
            String sql="INSERT INTO  `casos` (`id_caso`, `descripcion_caso`,`archivo_pdf`,`id_estado`) VALUES (?, ?, ?, 3);";
            this.conectar();
            st= conexion.prepareStatement(sql);
            st.setInt(1, casos.getId_caso());
            st.setString(2,casos.getDescripcion_caso());
            st.setString(3, casos.getArchivo_pdf());
            filasafectadas=st.executeUpdate();
            this.desconectar();
            return filasafectadas;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }

    public CasosBeans obtenerCasos(int id) throws SQLException{
        try{
            String sql="Select*from casos where id_caso=?";
            this.conectar();
            cs = conexion.prepareCall(sql);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if(rs.next()){
                CasosBeans casos=new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso"))); //de la bdd
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                casos.setIdEstado(Integer.parseInt(rs.getString("id_estado")));
                this.desconectar();
                return casos;
            }this.desconectar();
            return null;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }




    //ALEXANDER AYALA
    public List<CasosBeans> mostrarCasos() throws SQLException{
        try {
            List<CasosBeans> lista = new ArrayList<>();
            String sql = "SELECT casos.id_caso, casos.descripcion_caso, estado.estado, casos.archivo_pdf, departamento.departamento\n" +
                    "FROM casos\n" +
                    "INNER JOIN estado ON casos.id_estado = estado.id_estado\n" +
                    "INNER JOIN departamento ON casos.id_departamento = departamento.id_departamento\n" +
                    "WHERE estado.id_estado = 3\n" +
                    "ORDER BY casos.id_caso ASC;\n";

            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                CasosBeans casos = new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                casos.setId_estado(rs.getString("estado"));
                casos.setArchivo_pdf(rs.getString("archivo_pdf"));
                casos.setId_departamento(rs.getString("departamento"));
                lista.add(casos);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return  null;
        }
    }

    public CasosBeans obtenerCaso(int id) throws SQLException{
        try {
            String sql = "SELECT id_caso, descripcion_caso, archivo_pdf FROM casos WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                CasosBeans casos = new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setArchivo_pdf(rs.getString("archivo_pdf"));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                this.desconectar();
                return casos;
            }
            this.desconectar();
            return null;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }
    public int aprobarCaso(CasosBeans casos) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "UPDATE casos set titulo_caso = ?, descripcion_caso = ?, archivo_pdf = ?, id_estado = 5 WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, casos.getTitulo_caso());
            st.setString(2, casos.getDescripcion_caso());
            st.setString(3, casos.getArchivo_pdf());
            st.setInt(4, casos.getId_caso());

            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            //Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return 0;
        }
    }

    public int rechazarCaso(CasosBeans casos) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "UPDATE casos set argumento = ?, descripcion_caso = ?, archivo_pdf = ?, id_estado = 4 WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, casos.getArgumento());
            st.setString(2, casos.getDescripcion_caso());
            st.setString(3, casos.getArchivo_pdf());
            st.setInt(4, casos.getId_caso());
            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            //Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return 0;
        }
    }

    //Desde aquí solo se va a manejar el darle a un programador un caso en particular.
    public List<CasosBeans> casosProgramadores() throws SQLException{
        try {
            List<CasosBeans> lista = new ArrayList<>();
            String sql = "SELECT c.id_caso, c.titulo_caso, c.descripcion_caso, c.archivo_pdf, d.departamento " +
                    "FROM casos c INNER JOIN departamento d ON c.id_departamento = d.id_departamento " +
                    "INNER JOIN estado e ON c.id_estado = e.id_estado " +
                    "WHERE c.id_estado = 5";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                CasosBeans caso = new CasosBeans();
                caso.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                caso.setTitulo_caso(rs.getString("titulo_caso"));
                caso.setDescripcion_caso(rs.getString("descripcion_caso"));
                caso.setArchivo_pdf(rs.getString("archivo_pdf"));
                caso.setId_departamento(rs.getString("departamento"));
                lista.add(caso);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return  null;
        }
    }

    public CasosBeans casoObtener(int id) throws SQLException{
        try {
            String sql = "SELECT id_caso, titulo_caso FROM casos WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()) {
                CasosBeans casos = new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setTitulo_caso(rs.getString("titulo_caso"));
                this.desconectar();
                return casos;
            }
            this.desconectar();
            return null;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }

    public int casoAsignado(CasosBeans casos) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "UPDATE casos SET id_programador = ?, fecha_solicitud = ?, fecha_limite = ?, id_estado = 6 WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, casos.getIdProgramador());
            st.setString(2, casos.getFecha_solicitud());
            st.setString(3, casos.getFecha_limite());
            st.setInt(4, casos.getId_caso());
            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }

    }

    //metodos que utiliza wilmer
    public CasosBeans obtenerCasoBic(int id) throws SQLException{
        try {
            String sql = "SELECT id_caso, id_estado, titulo_caso, fecha_limite FROM casos WHERE id_caso = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                CasosBeans casosbi = new CasosBeans();
                casosbi.setTitulo_caso(rs.getString("titulo_caso"));
                casosbi.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casosbi.setIdEstado(Integer.parseInt(rs.getString("id_estado")));
                casosbi.setFecha_limite(rs.getString("fecha_limite"));
                this.desconectar();
                return casosbi;
            }
            this.desconectar();
            return null;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }
    /**************************metodos para la parte de bitacora**************************************************/
    public List<CasosBeans> mostrarCasosBic() throws SQLException{
        try {
            List<CasosBeans> lista = new ArrayList<>();
            String sql = "SELECT casos.id_caso, casos.descripcion_caso, estado.estado, casos.titulo_caso, casos.fecha_limite\n" +
                    "FROM casos\n" +
                    "INNER JOIN estado ON casos.id_estado = estado.id_estado\n" +
                    "WHERE estado.id_estado = 7\n" +
                    "ORDER BY casos.id_caso ASC;\n";

            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                CasosBeans casos = new CasosBeans();
                casos.setId_caso(Integer.parseInt(rs.getString("id_caso")));
                casos.setDescripcion_caso(rs.getString("descripcion_caso"));
                casos.setId_estado(rs.getString("estado"));
                casos.setTitulo_caso(rs.getString("titulo_caso"));
                casos.setFecha_limite(rs.getString("fecha_limite"));
                lista.add(casos);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return  null;
        }
    }
}
