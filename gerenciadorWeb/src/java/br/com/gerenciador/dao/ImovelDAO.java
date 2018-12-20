/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Imovel;
import br.com.gerenciador.util.Util;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author danieldruszcz
 */
public class ImovelDAO implements Serializable{
    
    public List<Imovel> list(Imovel filtro) throws IOException{
        Gson g = new Gson();
        String filtroJson = g.toJson(filtro);
        String jsonResponse = Util.sendPost("imovel/list", filtroJson);
        return (List<Imovel>) Util.jsonToObject(jsonResponse, List.class);
    }
}
