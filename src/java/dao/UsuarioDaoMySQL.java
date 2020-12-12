package dao;

import dal.Conexion;
import dto.Usuario;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class UsuarioDaoMySQL extends UsuarioDao {

    @Override
    public int insert(Usuario obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO usuario (nombreCompleto, username, password, tipoUsuario) VALUES (");
        query.append("'" + obj.getNombreCompleto() + "',");
        query.append("'" + obj.getUsername() + "',");
        query.append("'" + obj.getPassword() + "',");
        query.append("'" + obj.getTipoUsuario() + "' ");
        query.append(")");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Usuario obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE usuario SET ");
        query.append("nombreCompleto = '" + obj.getNombreCompleto() + "',");
        query.append("username = '" + obj.getUsername() + "',");
        query.append("password = '" + obj.getPassword() + "',");
        query.append("tipoUsuario = '" + obj.getTipoUsuario() + "' ");
        query.append("WHERE usuarioId = " + obj.getUsuarioId());
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuffer query = new StringBuffer("DELETE FROM usuario ");
        query.append("WHERE usuarioId = " + id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public Usuario get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM usuario WHERE usuarioId = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Usuario obj = new Usuario();
                int _usuarioId = objResultSet.getInt("usuarioId");
                obj.setUsuarioId(_usuarioId);

                String _nombreCompleto = objResultSet.getString("nombreCompleto");
                obj.setNombreCompleto(_nombreCompleto);

                String _username = objResultSet.getString("username");
                obj.setUsername(_username);

                String _password = objResultSet.getString("password");
                obj.setPassword(_password);

                String _tipoUsuario = objResultSet.getString("tipoUsuario");
                obj.setTipoUsuario(_tipoUsuario);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> getList() {
        ArrayList<Usuario> registros = new ArrayList<Usuario>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM usuario";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Usuario obj = new Usuario();
                int _usuarioId = objResultSet.getInt("usuarioId");
                obj.setUsuarioId(_usuarioId);

                String _nombreCompleto = objResultSet.getString("nombreCompleto");
                obj.setNombreCompleto(_nombreCompleto);

                String _username = objResultSet.getString("username");
                obj.setUsername(_username);

                String _password = objResultSet.getString("password");
                obj.setPassword(_password);

                String _tipoUsuario = objResultSet.getString("tipoUsuario");
                obj.setTipoUsuario(_tipoUsuario);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

    public Usuario get(String username, String password) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM usuario WHERE username = '" + username + "' and password ='" + password + "'";
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Usuario obj = new Usuario();
                int _usuarioId = objResultSet.getInt("usuarioId");
                obj.setUsuarioId(_usuarioId);

                String _nombreCompleto = objResultSet.getString("nombreCompleto");
                obj.setNombreCompleto(_nombreCompleto);

                String _username = objResultSet.getString("username");
                obj.setUsername(_username);

                String _password = objResultSet.getString("password");
                obj.setPassword(_password);
                
                obj.setTipoUsuario("CLIENTE");
                
                return obj;
            }
        } catch (Exception ex) {
            
        }
        return null;
    }

}
