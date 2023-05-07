package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.edu.udb.www.beans.*;

public class DepartamentoModel extends Conexion{
    public List<DepartamentoBeans> listaDepartamentos() throws SQLException{
        try{
            List<DepartamentoBeans> lista=new ArrayList<>();
            String sql="select*from departamento order by id_departamento";
            this.conectar();
            cs=conexion.prepareCall(sql);
            rs=cs.executeQuery();

            while (rs.next()){
                DepartamentoBeans departamento =new DepartamentoBeans();
                departamento.setIddepartamento(rs.getInt("id_departamento"));
                departamento.setDepartamento(rs.getString("departamento"));
                lista.add(departamento);
            }this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }
}
