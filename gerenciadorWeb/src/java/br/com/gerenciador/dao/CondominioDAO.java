/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Condominio;
import java.io.Serializable;

/**
 *
 * @author danieldruszcz
 */
public class CondominioDAO extends GenericDAO<Condominio> implements Serializable{
    
    public CondominioDAO(){
        super.clazz = Condominio[].class;
        super.c = Condominio.class;
        super.listOp = "condominio/search";
        super.itemOp = "condominio/getById/";
        super.countOp = "condominio/count";
        super.saveOp = "condominio/salvar";
    }
    
}
