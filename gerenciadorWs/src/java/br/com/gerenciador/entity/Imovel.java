/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author danieldruszcz
 */
@Entity
@Table(name = "tb_imovel")
public class Imovel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "finalidade", nullable = false)
    private Integer finalidade;
    @Column(name = "tipo", nullable = false)
    private Integer tipo;
    @Column(name = "nrDormitorios", nullable = false)
    private Integer nrDormitorios;
    @Column(name = "possuiSuite", nullable = false)
    private Integer possuiSuite;
    @Column(name = "possuiGaragem", nullable = false)
    private Integer possuiGaragem;
    @Column(name = "possuiElevador", nullable = false)
    private Integer possuiElevador;
    @Column(name = "possuiAreaLazer", nullable = false)
    private Integer possuiAreaLazer;
    @Column(name = "rua", nullable = false)
    private String rua;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "nr", nullable = false)
    private String nr;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "uf", nullable = false)
    private String uf;
    @Column(name = "preco", nullable = false)
    private String preco;
    @Column(name = "areaTotal", nullable = false)
    private String areaTotal;
    @Column(name = "areaUtil", nullable = false)
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
