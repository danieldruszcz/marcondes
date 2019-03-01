/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Imovel;

/**
 *
 * @author danieldruszcz
 */
public class ImovelDAO extends GenericDAO<Imovel, Long> {

    public Imovel getById(Long id) {
        return super.getById(Imovel.class, id);
    }

    public String getQuery(Imovel filtro) {
        StringBuilder sql = new StringBuilder();
        sql.append("Imovel o ");
        sql.append("where o.id > 0 ");
        if (filtro != null) {
            if (filtro.getRua() != null && !filtro.getRua().isEmpty()) {
                sql.append(" and o.rua like '%").append(filtro.getRua()).append("%'");
            }
            if (filtro.getCidade() != null && !filtro.getCidade().isEmpty()) {
                sql.append(" and o.cidade = " + filtro.getCidade());
            }
        }
        System.out.println("Query " + sql.toString());
        return sql.toString();
    }
}
