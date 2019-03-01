package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Vendedor;
import java.util.List;

public class VendedorDAO extends GenericDAO<Vendedor, Long>{

   public Vendedor getById(Long id){
       return super.getById(Vendedor.class, id);
   }
   
   public List<Vendedor> getListVendedor(){
       return super.getAll(Vendedor.class);
   }

    @Override
    protected String getQuery(Vendedor filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
