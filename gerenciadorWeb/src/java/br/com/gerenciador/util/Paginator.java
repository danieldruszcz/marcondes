/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.util;

import java.io.Serializable;

/**
 *
 * @author danieldruszcz
 */
public class Paginator implements Serializable{
    
    private int first;
    private Object filter;
    private int totalItens;
    private int itensPPage;
    private int pages;
    private int page;
    
    public Paginator(Object filter, int totalItens, int itensPPage){
        this.first = 0;
        this.filter = filter;
        this.totalItens = totalItens;
        this.itensPPage = itensPPage;
        this.calcTotalPages();
        this.page = 0;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public Object getFilter() {
        return filter;
    }

    public void setFilter(Object filter) {
        this.filter = filter;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    public int getItensPPage() {
        return itensPPage;
    }

    public void setItensPPage(int itensPPage) {
        this.itensPPage = itensPPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    public void changePage(){
        this.first = ((this.page - 1) * this.itensPPage);
    }
    
    public void calcTotalPages(){
        this.pages = this.totalItens / this.itensPPage + (this.totalItens % this.itensPPage > 0 ? 1 : 0);
    }
}
