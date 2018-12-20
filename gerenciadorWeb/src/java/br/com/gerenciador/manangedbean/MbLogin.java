/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import br.com.gerenciador.dao.UsuarioDAO;
import br.com.gerenciador.entity.Usuario;
import br.com.gerenciador.util.Util;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbLogin")
@ViewScoped
public class MbLogin implements Serializable {

    private String email;
    private String senha;
    private Usuario user;
    
    @PostConstruct
    public void init(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        this.user = (Usuario) session.getAttribute("logged_user");
    }

    public void doLogin() {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            System.out.println("Senha " + this.senha);
            Usuario usuario = dao.login(email, Util.hash("SHA-1", senha));
            System.out.println("User " + usuario.getNome());
            if (usuario != null) {
                if (usuario.getStatus() == 1) {
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    session.setAttribute("logged_user", usuario);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/gerenciadorWeb/pages/sistema/home.xhtml");
                    FacesContext.getCurrentInstance().responseComplete();
                } else {

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MbLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MbLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doLogout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/gerenciadorWeb/pages/login.xhtml");
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}
