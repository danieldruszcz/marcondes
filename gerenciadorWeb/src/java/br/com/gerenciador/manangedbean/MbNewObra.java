/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import br.com.gerenciador.dao.ObraDAO;
import br.com.gerenciador.entity.Obra;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbNewObra")
@ViewScoped
public class MbNewObra extends AbstractMbNew<Obra> implements Serializable {

    @Override
    protected void initPage() {
        super.type = Obra.class;
        super.dao = new ObraDAO();
    }

}
