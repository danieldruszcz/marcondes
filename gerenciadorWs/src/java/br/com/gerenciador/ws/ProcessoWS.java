/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.ws;

import br.com.gerenciador.dao.ProcessoDAO;
import br.com.gerenciador.entity.Processo;
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
@Path("/processo")
public class ProcessoWS {
     
    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Processo salvar(Processo processo) throws Exception {
        ProcessoDAO dao = new ProcessoDAO();
        try {
            dao.save(processo);
            return processo;
        } catch (Exception ex) {
            Logger.getLogger(ProcessoWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/search/{first}/{itens}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Processo> list(@PathParam("first") int first, @PathParam("itens") int itens, Processo processo) throws Exception {
        ProcessoDAO dao = new ProcessoDAO();
        try {
            Paginator paginator = new Paginator(first, itens, processo);
            return dao.pesquisar(paginator);
        } catch (Exception ex) {
            Logger.getLogger(ProcessoWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
       
    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Processo> list() throws Exception {
        ProcessoDAO dao = new ProcessoDAO();
        try {
            return dao.getAll(Processo.class);
        } catch (Exception ex) {
            Logger.getLogger(ProcessoWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
        
    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Processo getById(@PathParam("id") Long id) throws Exception {
        ProcessoDAO dao = new ProcessoDAO();
        try {
            return dao.getById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProcessoWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
         
    @POST
    @Path("/count")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer count(Processo processo) throws Exception {
        ProcessoDAO dao = new ProcessoDAO();
        try {
            return dao.count(processo);
        } catch (Exception ex) {
            Logger.getLogger(ProcessoWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
