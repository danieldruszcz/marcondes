/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Imovel;
import java.util.List;

/**
 *
 * @author danieldruszcz
 */
public class ImovelDAO extends GenericDAO<Imovel, Long> {
    
    public Imovel getById(Long id) {
        return super.getById(Imovel.class, id);
    }

    public List<Imovel> getListVendedor() {
        return super.getAll(Imovel.class);
    }
}
