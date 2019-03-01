/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import br.com.gerenciador.dao.GenericDAO;
import br.com.gerenciador.util.Generic;
import br.com.gerenciador.util.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author danieldruszcz
 */
public abstract class AbstractMbNew<T> {

    protected GenericDAO dao;
    protected T objetoSelecionado;
    protected Class<T> type;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        try {
            this.initPage();
            Long id = Util.getIdFromRequest(FacesContext.getCurrentInstance().getExternalContext());
            if (id != null && id > 0) {

                this.objetoSelecionado = (T) this.dao.getItem(id);
                this.isEdit = true;
            } else {

                Generic<T> genericClass = new Generic<>(type);
                this.objetoSelecionado = genericClass.buildOne();
                this.isEdit = false;
            }
        } catch (IOException | InstantiationException | IllegalAccessException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao carregar registro.", null));
            Logger.getLogger(AbstractMbList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() {
        try {
            this.dao.salvar(this.objetoSelecionado);
            this.isEdit = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro cadastrado com sucesso!", null));
        } catch (IOException ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao cadastrar registro.", null));
        }
    }
    
    protected abstract void initPage();

    public T getObjetoSelecionado() {
        return objetoSelecionado;
    }

    public void setObjetoSelecionado(T objetoSelecionado) {
        this.objetoSelecionado = objetoSelecionado;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

}
