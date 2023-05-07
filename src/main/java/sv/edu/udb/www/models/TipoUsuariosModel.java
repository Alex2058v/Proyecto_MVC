package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.edu.udb.www.beans.*;

public class TipoUsuariosModel extends Conexion {
    public List<TipoUsuarioBeans> listaTipoDeUsuario() throws SQLException{
        try{
            List<TipoUsuarioBeans> lista=new ArrayList<>();
            String sql="select-from tipo_usuario order by id_tipousuario";
            this.conectar();
            cs=conexion.prepareCall(sql);
            rs=cs.executeQuery();
            while(rs.next()){
                TipoUsuarioBeans tipoUsuario = new TipoUsuarioBeans();
                tipoUsuario.setIdtipousuario(rs.getInt("id_tipousuario"));
                tipoUsuario.setTipousuario(rs.getString("tipo_usuario"));
                lista.add(tipoUsuario);
            }this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }
}
