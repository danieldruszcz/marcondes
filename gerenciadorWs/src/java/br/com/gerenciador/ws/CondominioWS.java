/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.ws;

import br.com.gerenciador.dao.CondominioDAO;
import br.com.gerenciador.entity.Condominio;
import br.com.gerenciador.util.Paginator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author danieldruszcz
 */
@Path("/condominio")
public class CondominioWS {
     
    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Condominio salvar(Condominio condominio) throws Exception {
        CondominioDAO dao = new CondominioDAO();
        try {
            dao.save(condominio);
            return condominio;
        } catch (Exception ex) {
            Logger.getLogger(CondominioWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/search/{first}/{itens}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Condominio> list(@PathParam("first") int first, @PathParam("itens") int itens, Condominio condominio) throws Exception {
        CondominioDAO dao = new CondominioDAO();
        try {
            Paginator paginator = new Paginator(first, itens, condominio);
            return dao.pesquisar(paginator);
        } catch (Exception ex) {
            Logger.getLogger(CondominioWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
       
    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Condominio> list() throws Exception {
        CondominioDAO dao = new CondominioDAO();
        try {
            return dao.getAll(Condominio.class);
        } catch (Exception ex) {
            Logger.getLogger(CondominioWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
        
    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Condominio getById(@PathParam("id") Long id) throws Exception {
        CondominioDAO dao = new CondominioDAO();
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            Logger.getLogger(CondominioWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/count")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer count(Condominio condominio) throws Exception {
        CondominioDAO dao = new CondominioDAO();
        try {
            return dao.count(condominio);
        } catch (Exception ex) {
            Logger.getLogger(CondominioWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
