/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Imovel;
import br.com.gerenciador.util.Paginator;
import br.com.gerenciador.util.Util;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author danieldruszcz
 */
public class GenericDAO<T> {
    
    protected Class<T[]> clazz;
    protected Class c;
    protected String itemOp;
    protected String listOp;
    protected String countOp;
    protected String saveOp;
    
     public List<T> search(Paginator paginator) throws IOException{
        Gson g = new Gson();
        String filtroJson = g.toJson(paginator.getFilter());
        String jsonResponse = Util.sendPost(listOp + "/" + paginator.getFirst() + "/" + paginator.getItensPPage() , filtroJson);
        return (List<T>) Util.jsonToArray(jsonResponse, clazz);
    }
    
    public T getItem(Long id) throws IOException{
        String jsonResponse = Util.sendGet(itemOp + id);
        return (T) Util.jsonToObject(jsonResponse, c);
    }
    
    public Integer getItemCount(T filtro) throws IOException{
        Gson g = new Gson();
        String filtroJson = g.toJson(filtro);
        String jsonResponse = Util.sendPost(countOp, filtroJson);
        return (Integer) Util.jsonToObject(jsonResponse, Integer.class);
    }
    
    public void salvar(T objeto) throws IOException{
  
        Util.sendPost(saveOp, this.objectToJson(objeto));
    }
    
    private String objectToJson(T objeto){
        Gson g = new Gson();
        return g.toJson(objeto);
    }
}
