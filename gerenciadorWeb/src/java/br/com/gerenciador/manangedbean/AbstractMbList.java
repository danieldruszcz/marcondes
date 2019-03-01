/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import br.com.gerenciador.dao.GenericDAO;
import br.com.gerenciador.util.Generic;
import br.com.gerenciador.util.Paginator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author danieldruszcz
 */
public abstract class AbstractMbList<T> {
    
    protected GenericDAO dao;
    protected Paginator p;
    protected List<T> listResultados;
    protected Class<T> type;
    protected int intensPorPagina;

    public Paginator getP() {
        return p;
    }

    public void setP(Paginator p) {
        this.p = p;
    }

    public List<T> getListResultados() {
        return listResultados;
    }

    public void setListResultados(List<T> listResultados) {
        this.listResultados = listResultados;
    }
    
    @PostConstruct
    public void init(){
        this.initPage();
        try {
            Generic<T> genericClass = new Generic<T>(type);
            T newObject = genericClass.buildOne();
            p = new Paginator(newObject, dao.getItemCount(newObject), this.intensPorPagina);
            listResultados = dao.search(p);
        } catch (IOException ex) {
            Logger.getLogger(MbListImoveis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractMbList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractMbList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    protected abstract void initPage();
    
    public void pesquisar(){
        try {
            p.setTotalItens(dao.getItemCount(p.getFilter()));
            p.calcTotalPages();
            this.listResultados = dao.search(p);
        } catch (IOException ex) {
            Logger.getLogger(AbstractMbList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void changePage(){
        try {
            this.p.changePage();
            this.listResultados = dao.search(p);
        } catch (IOException ex) {
            Logger.getLogger(AbstractMbList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
