/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.util;

import java.io.Serializable;
import java.util.List;

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
    
    public Paginator(int first, int itensPPage, Object filter){
        this.first = first;
        this.itensPPage = itensPPage;
        this.filter = filter;
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
}
