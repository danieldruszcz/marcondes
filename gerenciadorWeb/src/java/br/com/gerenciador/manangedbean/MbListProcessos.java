/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;


import br.com.gerenciador.dao.ProcessoDAO;
import br.com.gerenciador.entity.Processo;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbListProcessos")
@ViewScoped
public class MbListProcessos extends AbstractMbList<Processo> implements Serializable{

    @Override
    protected void initPage() {
        super.dao = new ProcessoDAO();
        super.type = Processo.class;
        super.intensPorPagina = 12;
    }
    
}
