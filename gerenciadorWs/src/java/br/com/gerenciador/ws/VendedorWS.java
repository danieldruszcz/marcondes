package br.com.gerenciador.ws;

import br.com.gerenciador.dao.VendedorDAO;
import br.com.gerenciador.entity.Vendedor;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vendedor")
public class VendedorWS {

    @GET
    @Path("/{name}")
    public void salvar(@PathParam("name") String name) {
        Vendedor v = new Vendedor();
        v.setNome(name);
        v.setTelefone("(42) 2424-2424");
        v.setDataNascimento(new Date());
        VendedorDAO dao = new VendedorDAO();
        try {
            dao.save(v);
        } catch (Exception ex) {
            Logger.getLogger(VendedorWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("/pesquisar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vendedor pesquisar(@PathParam("id") Long id) {
        VendedorDAO dao = new VendedorDAO();
        Vendedor v = dao.getById(id);
        return v;
    }

    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vendedor salvar(Vendedor vendedor) throws Exception {
        VendedorDAO dao = new VendedorDAO();
        try {
            dao.save(vendedor);
            return vendedor;
        } catch (Exception ex) {
            Logger.getLogger(VendedorWS.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
