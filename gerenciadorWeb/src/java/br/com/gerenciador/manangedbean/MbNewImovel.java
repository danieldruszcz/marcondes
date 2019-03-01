/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.manangedbean;

import br.com.gerenciador.dao.ImovelDAO;
import br.com.gerenciador.entity.Imovel;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author danieldruszcz
 */
@ManagedBean(name = "mbNewImovel")
@ViewScoped
public class MbNewImovel extends AbstractMbNew<Imovel> implements Serializable {

    @Override
    protected void initPage() {
        super.type = Imovel.class;
        super.dao = new ImovelDAO();
    }

}
