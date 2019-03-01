/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Imovel;
import java.io.Serializable;

/**
 *
 * @author danieldruszcz
 */
public class ImovelDAO extends GenericDAO<Imovel> implements Serializable{
    
    public ImovelDAO(){
        super.clazz = Imovel[].class;
        super.c = Imovel.class;
        super.listOp = "imovel/search";
        super.itemOp = "imovel/getById/";
        super.countOp = "imovel/count";
        super.saveOp = "imovel/salvar";
    }
    
}
