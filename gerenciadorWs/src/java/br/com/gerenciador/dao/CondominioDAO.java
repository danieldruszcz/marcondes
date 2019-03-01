/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Condominio;

/**
 *
 * @author danieldruszcz
 */
public class CondominioDAO extends GenericDAO<Condominio, Long> {

    public Condominio getById(Long id) {
        return super.getById(Condominio.class, id);
    }

    public String getQuery(Condominio filtro) {
        StringBuilder sql = new StringBuilder();
        sql.append("Condominio o ");
        sql.append("where o.id > 0 ");
        if (filtro != null) {
            if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
                sql.append(" and o.descricao like '%").append(filtro.getDescricao()).append("%'");
            }
        }
        return sql.toString();
    }
}
