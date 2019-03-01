/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Processo;
import java.io.Serializable;

/**
 *
 * @author danieldruszcz
 */
public class ProcessoDAO extends GenericDAO<Processo> implements Serializable{
    
    public ProcessoDAO(){
        super.clazz = Processo[].class;
        super.c = Processo.class;
        super.listOp = "processo/search";
        super.itemOp = "processo/getById/";
        super.countOp = "processo/count";
        super.saveOp = "processo/salvar";
    }
    
}
