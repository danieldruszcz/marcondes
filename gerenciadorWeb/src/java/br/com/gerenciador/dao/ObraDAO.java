/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Obra;
import java.io.Serializable;

/**
 *
 * @author danieldruszcz
 */
public class ObraDAO extends GenericDAO<Obra> implements Serializable{
    
    public ObraDAO(){
        super.clazz = Obra[].class;
        super.c = Obra.class;
        super.listOp = "obra/search";
        super.itemOp = "obra/getById/";
        super.countOp = "obra/count";
        super.saveOp = "obra/salvar";
    }
    
}
