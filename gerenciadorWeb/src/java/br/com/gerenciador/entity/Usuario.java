/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.entity;

import java.util.Date;

/**
 *
 * @author danieldruszcz
 */
public class Usuario {

    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String celular;
    private int status;
    private Date dataCriacao;
    private Date dataEdicao;
    private int usuarioCriacao;
    private int usuarioEdicao;
    
    private Perfil perfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public int getUsuarioCriacao() {
        return usuarioCriacao;
    }

    public void setUsuarioCriacao(int usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    public int getUsuarioEdicao() {
        return usuarioEdicao;
    }

    public void setUsuarioEdicao(int usuarioEdicao) {
        this.usuarioEdicao = usuarioEdicao;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
}
