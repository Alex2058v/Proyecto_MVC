package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.edu.udb.www.beans.*;

public class EstadosModel extends Conexion{
    public List<EstadoBeans> listaEstados() throws SQLException{
        try{
            List<EstadoBeans> lista= new ArrayList<>();
            String sql="select*from estado order by id_estado";
            this.conectar();
            cs=conexion.prepareCall(sql);
            rs=cs.executeQuery();
            while (rs.next()){
                EstadoBeans estado=new EstadoBeans();
                estado.setIdestado(rs.getInt("id_estado"));
                estado.setEstado(rs.getString("estado"));
                lista.add(estado);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }
}
