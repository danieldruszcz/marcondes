/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.ws;

import br.com.gerenciador.dao.ImovelDAO;
import br.com.gerenciador.entity.Imovel;
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
@Path("/imovel")
public class ImovelWS {
     
    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Imovel salvar(Imovel imovel) throws Exception {
        ImovelDAO dao = new ImovelDAO();
        try {
            dao.save(imovel);
            return imovel;
        } catch (Exception ex) {
            Logger.getLogger(ImovelWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/search/{first}/{itens}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Imovel> list(@PathParam("first") int first, @PathParam("itens") int itens, Imovel imovel) throws Exception {
        ImovelDAO dao = new ImovelDAO();
        try {
            System.out.println("T 2 " + first + "last " + itens);
            Paginator paginator = new Paginator(first, itens, imovel);
            return dao.pesquisar(paginator);
        } catch (Exception ex) {
            Logger.getLogger(ImovelWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
       
    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Imovel> list() throws Exception {
        ImovelDAO dao = new ImovelDAO();
        try {
            return dao.getAll(Imovel.class);
        } catch (Exception ex) {
            Logger.getLogger(ImovelWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
        
    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Imovel getById(@PathParam("id") Long id) throws Exception {
        ImovelDAO dao = new ImovelDAO();
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            Logger.getLogger(ImovelWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/count")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer count(Imovel imovel) throws Exception {
        ImovelDAO dao = new ImovelDAO();
        try {
            System.out.println("T " + imovel.getRua());
            return dao.count(imovel);
        } catch (Exception ex) {
            Logger.getLogger(ImovelWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
