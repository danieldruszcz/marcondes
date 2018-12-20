/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import br.com.gerenciador.dao.ImovelDAO;
import br.com.gerenciador.entity.Imovel;
import br.com.gerenciador.util.Util;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbNewImovel")
@ViewScoped
public class MbNewImovel implements Serializable{
    
    private Imovel novoImovel;
    private ImovelDAO dao;
    private boolean isEdit;
    
    @PostConstruct
    public void init(){
        this.novoImovel = new Imovel();
        this.dao = new ImovelDAO();
        this.isEdit = false;
    }

    public void salvar() throws IOException{
        Gson g = new Gson();
        String jsonImovel = g.toJson(this.novoImovel);
        Util.sendPost("imovel/salvar", jsonImovel);
        this.isEdit = true;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro cadastrado com sucesso!", null));
    }
    
    public Imovel getNovoImovel() {
        return novoImovel;
    }

    public void setNovoImovel(Imovel novoImovel) {
        this.novoImovel = novoImovel;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
