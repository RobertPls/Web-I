/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.UsuarioDao;
import dao.UsuarioDaoMySQL;
import dto.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author josec
 */
@Path("/usuario")
public class UsuarioService {

    // /api/usuario/login
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta login(Usuario datosLogin) {
        try {
            UsuarioDao dao = new UsuarioDaoMySQL();
            Usuario obj = dao.get(datosLogin.getUsername(),datosLogin.getPassword());
            
            if (obj == null) {
                return new Respuesta(true,"Usuario y/o Contraseña incorrectos");
            }
            if (obj.getPassword().equals(datosLogin.getPassword())) {
                String json = " { "
                        + "\"nombreCompleto\" : \"" + obj.getNombreCompleto() + "\","
                        + "\"username\" : \"" + obj.getUsername() + "\","
                        + "\"usuarioId\" : " + obj.getUsuarioId() + ""
                        + "}";

                return new Respuesta(true, json);
            } else {
                return new Respuesta(false, "Usuario y/o Contraseña incorrectos");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Respuesta(false, "Ocurrió un error al verificar el usuario");
    }
}
