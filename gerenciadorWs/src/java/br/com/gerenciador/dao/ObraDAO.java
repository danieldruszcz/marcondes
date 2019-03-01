/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Obra;

/**
 *
 * @author danieldruszcz
 */
public class ObraDAO extends GenericDAO<Obra, Long> {

    public Obra getById(Long id) {
        return super.getById(Obra.class, id);
    }

    public String getQuery(Obra filtro) {
        StringBuilder sql = new StringBuilder();
        sql.append("Obra o ");
        sql.append("where o.id > 0 ");
        if (filtro != null) {
            if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
                sql.append(" and o.descricao like '%").append(filtro.getDescricao()).append("%'");
            }
        }
        return sql.toString();
    }
}
