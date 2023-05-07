package sv.edu.udb.www.models;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.www.beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosModel extends Conexion{
    public List<UsuariosBeans> mostrarUsuarios() throws SQLException{
        try {
            List<UsuariosBeans> lista = new ArrayList<>();
            String sql = "SELECT id_usuario, CONCAT(nombres, ' ', apellidos) as nombre_completo FROM usuarios WHERE id_tipousuario = 4";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()){
                UsuariosBeans linea = new UsuariosBeans();
                linea.setId_usuario(rs.getInt("id_usuario"));
                linea.setNombres(rs.getString("nombre_completo"));
                lista.add(linea);
            }
            this.desconectar();
            return lista;
        }catch (SQLException ex) {
            this.desconectar();
            return null;
        }
    }


    //Validacion para Login
    public UsuariosBeans validarUsuario(String usuario, String contrasenia) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contrasenia);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    UsuariosBeans user = new UsuariosBeans();
                    user.setId_usuario(rs.getInt("id_usuario"));
                    user.setUsuario(rs.getString("usuario"));
                    user.setContrasenia(rs.getString("contrasenia"));
                    user.setNombres(rs.getString("nombres"));
                    user.setApellidos(rs.getString("apellidos"));
                    user.setIdTipousuario(rs.getInt("id_tipousuario"));
                    return user;
                }
            }
        }
        return null;
    }

}