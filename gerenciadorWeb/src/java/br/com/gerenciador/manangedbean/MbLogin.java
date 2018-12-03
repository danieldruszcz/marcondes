/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbLogin")
@ViewScoped
public class MbLogin implements Serializable {

    private String email;
    private String senha;

    public void doLogin() {
        System.out.println("br.com.gerenciador.manangedbean.MbLogin.doLogin()");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/gerenciadorWeb/pages/sistema/home.xhtml");
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(MbLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
