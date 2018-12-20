/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.ws;

import br.com.gerenciador.dao.UsuarioDAO;
import br.com.gerenciador.entity.Usuario;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danieldruszcz
 */
@Path("/usuario")
public class UsuarioWS {
    
    
    @GET
    @Path("/login/{usuario}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario login(@PathParam("usuario") String usuario, @PathParam("senha") String senha ) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.getUser(usuario, senha);
        return u;
    }
    
}
