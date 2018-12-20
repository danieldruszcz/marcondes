/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.entity;

import java.io.Serializable;

/**
 *
 * @author danieldruszcz
 */
public class Imovel implements Serializable{
    
    private Long id;
    private Integer finalidade;
    private Integer tipo;
    private Integer nrDormitorios;
    private Integer possuiSuite;
    private Integer possuiGaragem;
    private Integer possuiElevador;
    private Integer possuiAreaLazer;
    private String rua;
    private String bairro;
    private String nr;
    private String cidade;
    private String uf;
    private String preco;
    private String areaTotal;
    private String areaUtil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(Integer finalidade) {
        this.finalidade = finalidade;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getNrDormitorios() {
        return nrDormitorios;
    }

    public void setNrDormitorios(Integer nrDormitorios) {
        this.nrDormitorios = nrDormitorios;
    }

    public Integer getPossuiSuite() {
        return possuiSuite;
    }

    public void setPossuiSuite(Integer possuiSuite) {
        this.possuiSuite = possuiSuite;
    }

    public Integer getPossuiGaragem() {
        return possuiGaragem;
    }

    public void setPossuiGaragem(Integer possuiGaragem) {
        this.possuiGaragem = possuiGaragem;
    }

    public Integer getPossuiElevador() {
        return possuiElevador;
    }

    public void setPossuiElevador(Integer possuiElevador) {
        this.possuiElevador = possuiElevador;
    }

    public Integer getPossuiAreaLazer() {
        return possuiAreaLazer;
    }

    public void setPossuiAreaLazer(Integer possuiAreaLazer) {
        this.possuiAreaLazer = possuiAreaLazer;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(String areaTotal) {
        this.areaTotal = areaTotal;
    }

    public String getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(String areaUtil) {
        this.areaUtil = areaUtil;
    }
    
}
