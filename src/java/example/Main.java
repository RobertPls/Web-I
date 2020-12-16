/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import dal.Conexion;
import dao.UsuarioDao;
import dao.UsuarioDaoMySQL;
import dto.Usuario;
import factory.FactoryDao;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author josec
 */
public class Main {
    
    public static void main(String[] args) throws SQLException {
        UsuarioDao dao = new UsuarioDaoMySQL();
    /*    
        Usuario usr = new Usuario();
        usr.setNombreCompleto("Prueba");
        usr.setUsername("ppp");
        usr.setPassword("ppp");
        usr.setTipoUsuario("CLIENTE");
        
        try {
           // dao.insert(usr);
            System.out.println(dao.get(1).getPassword());
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }
}
