package sv.edu.udb.www.models;
import java.sql.SQLException;


public class JefeAreasModel extends Conexion {

    public int totalCasos() throws SQLException{
        try{
            int totCasos = 0;
            String sql = "select count(id_caso) as total from casos where id_estado = 3";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                totCasos = rs.getInt("total");
            }
            this.desconectar();
            return totCasos;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }
    public int totalAprobados() throws SQLException {
        try{
            int totCasos = 0;
            String sql = "select count(id_caso) as total from casos where id_estado = 5";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                totCasos = rs.getInt("total");
            }
            this.desconectar();
            return totCasos;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }

    public int totalrechazados() throws SQLException{
        try{
            int totCasos = 0;
            String sql = "select count(id_caso) as total from casos where id_estado = 4";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                totCasos = rs.getInt("total");
            }
            this.desconectar();
            return totCasos;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }
}
