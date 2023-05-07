package sv.edu.udb.www.models;

import sv.edu.udb.www.beans.BitacorasBeans;
import sv.edu.udb.www.beans.CasosBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitacorasModel extends Conexion{

    //parte encargada de manadar los datos a mostrar
    public List<BitacorasBeans> listarBitacoras() throws SQLException {
        try {

            List<BitacorasBeans> lista = new ArrayList<>();
            String sql = "SELECT * FROM bitacora";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                BitacorasBeans bitacora = new BitacorasBeans();
                bitacora.setId_bitacora(Integer.parseInt(rs.getString("id_bitacora")));
                bitacora.setFecha_limite(rs.getString("fecha_limite"));
                bitacora.setId_caso(Integer.parseInt(rs.getString("caso_id")));
                bitacora.setModificaciones(rs.getString("modificaciones"));
                bitacora.setAvance(rs.getString("actualizar_avance"));
                lista.add(bitacora);
            }
            this.desconectar();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(BitacorasModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return null;
        }
    }

    public BitacorasBeans obtenerBitacora(int id) throws SQLException{
        try {
            String sql = "SELECT b.id_bitacora, b.fecha_limite, b.modificaciones, b.actualizar_avance, b.caso_id, c.id_estado \n" +
                            "FROM bitacora b \n" +
                            "JOIN casos c ON b.caso_id = c.id_caso\n" +
                            "WHERE b.id_bitacora = ?";

            //String sql = "SELECT * FROM bitacora WHERE id_bitacora = ?";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                BitacorasBeans bitacora = new BitacorasBeans();
                CasosBeans caso = new CasosBeans();

                bitacora.setId_bitacora(Integer.parseInt(rs.getString("id_bitacora")));
                bitacora.setFecha_limite(rs.getString("fecha_limite"));
                bitacora.setModificaciones(rs.getString("modificaciones"));
                bitacora.setAvance(rs.getString("actualizar_avance"));
                bitacora.setId_caso(Integer.parseInt(rs.getString("caso_id")));
                caso.setId_caso(Integer.parseInt("id_estado"));
                this.desconectar();
                return bitacora;
            }
            this.desconectar();
            return null;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }


    public int crearBitacora(BitacorasBeans bitacora) throws SQLException{
        try{
            int filasAfectadas = 0;
            String sql = "INSERT INTO bitacora (id_bitacora, fecha_limite, caso_id, modificaciones, actualizar_avance) VALUES (?, ?, ?, ?, ?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setInt(1, bitacora.getId_bitacora());
            st.setString(2, bitacora.getFecha_limite());
            st.setInt(3, bitacora.getId_caso());
            st.setString(4, bitacora.getModificaciones());
            st.setString(5, bitacora.getAvance());

            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            //Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return 0;
        }
    }

    public int modificarBitacora(BitacorasBeans bitacora) throws SQLException{
        try{
            int filasAfectadas = 0;

            String sql = "UPDATE bitacora SET id_bitacora=?,fecha_limite=?,caso_id=?,modificaciones=?,actualizar_avance=? WHERE id_bitacora=?";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setInt(1, bitacora.getId_bitacora());
            st.setString(2, bitacora.getFecha_limite());
            st.setInt(3, bitacora.getId_caso());
            st.setString(4, bitacora.getModificaciones());
            st.setString(5, bitacora.getAvance());
            st.setInt(6, bitacora.getId_bitacora());

            filasAfectadas = st.executeUpdate();
            this.desconectar();
            return filasAfectadas;
        }catch (SQLException ex) {
            //Logger.getLogger(LibrosModel.class.getName()).log(Level.SEVERE, null, ex);
            this.desconectar();
            return 0;
        }
    }



}
