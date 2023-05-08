package sv.edu.udb.www.models;
import sv.edu.udb.www.beans.CasosBeans;
import sv.edu.udb.www.beans.DepartamentoBeans;
import sv.edu.udb.www.beans.TipoUsuarioBeans;
import sv.edu.udb.www.beans.UsuariosBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministradorModel extends Conexion{
    public int totalUsuarios() throws SQLException{
        try {
            int totUsuarios = 0;
            String sql = "select count(id_usuario) as total from usuarios";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                totUsuarios = rs.getInt("total");
            }
            this.desconectar();
            return totUsuarios;
        }catch (SQLException ex) {
            this.desconectar();
            return 0;
        }
    }

    public List<UsuariosBeans> listrarUsuarios() throws SQLException{
        try {
            List<UsuariosBeans> lista = new ArrayList<>();
            String sql = "SELECT u.id_usuario, u.nombres, u.apellidos, u.usuario,tu.tipo_usuario, d.departamento \n" +
                    "FROM usuarios u \n" +
                    "INNER JOIN tipo_usuario tu ON u.id_tipousuario = tu.id_tipousuario \n" +
                    "INNER JOIN departamento d ON u.id_departamento = d.id_departamento;";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                UsuariosBeans usuario = new UsuariosBeans();
                usuario.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setId_tipousuario(rs.getString("tipo_usuario"));
                usuario.setId_departamento(rs.getString("departamento"));
                lista.add(usuario);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return  null;
        }
    }

    public int eliminarUsuario(int id) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setInt(1, id);
            filasAfectadas = st.executeUpdate();
            return filasAfectadas;
        }catch (SQLException e){
            this.desconectar();
            return 0;
        }
    }

    public List<TipoUsuarioBeans> tipoUsuarios() throws SQLException{
        try {
            List<TipoUsuarioBeans> lista = new ArrayList<>();
            String sql = "select * from tipo_usuario order by id_tipousuario";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                TipoUsuarioBeans usuarios = new TipoUsuarioBeans();
                usuarios.setIdtipousuario(rs.getInt("id_tipousuario"));
                usuarios.setTipousuario(rs.getString("tipo_usuario"));
                lista.add(usuarios);
            }this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }

    public List<DepartamentoBeans> departamento() throws SQLException{
        try {
            List<DepartamentoBeans> lista = new ArrayList<>();
            String sql = "select * from departamento";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                DepartamentoBeans departamento = new DepartamentoBeans();
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

    public int ingresarUsuario(UsuariosBeans usuarios) throws SQLException{
        try {
            int filasAfectadas = 0;
            String sql = "INSERT INTO usuarios ( nombres, apellidos, id_departamento, id_tipousuario, usuario, contrasenia) VALUES ( ?, ?, ?, ?, ?, ?)";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, usuarios.getNombres());
            st.setString(2, usuarios.getApellidos());
            st.setInt(3, usuarios.getIdDepartamento());
            st.setInt(4, usuarios.getIdTipousuario());
            st.setString(5, usuarios.getUsuario());
            st.setString(6, usuarios.getContrasenia());

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