/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import br.com.gerenciador.dao.ImovelDAO;
import br.com.gerenciador.entity.Imovel;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbListImoveis")
@ViewScoped
public class MbListImoveis implements Serializable{
    
    private List<Imovel> listImoveis;
    private Imovel filtro = new Imovel();
    private ImovelDAO dao;
    private Integer paginas = 24;
    
    @PostConstruct
    public void init(){
        dao = new ImovelDAO();
        try {
            this.listImoveis = dao.list(filtro);
        } catch (IOException ex) {
            Logger.getLogger(MbListImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Imovel> getListImoveis() {
        return listImoveis;
    }

    public void setListImoveis(List<Imovel> listImoveis) {
        this.listImoveis = listImoveis;
    }

    public Imovel getFiltro() {
        return filtro;
    }

    public void setFiltro(Imovel filtro) {
        this.filtro = filtro;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
    
    
}
