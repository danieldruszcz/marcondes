/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;


import br.com.gerenciador.dao.CondominioDAO;
import br.com.gerenciador.entity.Condominio;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbListCondominio")
@ViewScoped
public class MbListCondominio extends AbstractMbList<Condominio> implements Serializable{

    @Override
    protected void initPage() {
        super.dao = new CondominioDAO();
        super.type = Condominio.class;
        super.intensPorPagina = 12;
    }
    
}
