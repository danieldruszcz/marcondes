/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.ws;

import br.com.gerenciador.dao.ObraDAO;
import br.com.gerenciador.entity.Obra;
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
@Path("/obra")
public class ObraWS {
     
    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Obra salvar(Obra obra) throws Exception {
        ObraDAO dao = new ObraDAO();
        try {
            dao.save(obra);
            return obra;
        } catch (Exception ex) {
            Logger.getLogger(ObraWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/search/{first}/{itens}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Obra> list(@PathParam("first") int first, @PathParam("itens") int itens, Obra obra) throws Exception {
        ObraDAO dao = new ObraDAO();
        try {
            Paginator paginator = new Paginator(first, itens, obra);
            return dao.pesquisar(paginator);
        } catch (Exception ex) {
            Logger.getLogger(ObraWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
       
    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Obra> list() throws Exception {
        ObraDAO dao = new ObraDAO();
        try {
            return dao.getAll(Obra.class);
        } catch (Exception ex) {
            Logger.getLogger(ObraWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
        
    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Obra getById(@PathParam("id") Long id) throws Exception {
        ObraDAO dao = new ObraDAO();
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            Logger.getLogger(ObraWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/count")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer count(Obra obra) throws Exception {
        ObraDAO dao = new ObraDAO();
        try {
            return dao.count(obra);
        } catch (Exception ex) {
            Logger.getLogger(ObraWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
