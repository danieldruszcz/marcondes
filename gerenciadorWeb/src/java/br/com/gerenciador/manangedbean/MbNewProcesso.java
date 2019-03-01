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
@ManagedBean(name = "mbNewProcesso")
@ViewScoped
public class MbNewProcesso extends AbstractMbNew<Processo> implements Serializable {

    @Override
    protected void initPage() {
        super.type = Processo.class;
        super.dao = new ProcessoDAO();
    }

}
