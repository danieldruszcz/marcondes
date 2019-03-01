/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Processo;

/**
 *
 * @author danieldruszcz
 */
public class ProcessoDAO extends GenericDAO<Processo, Long> {

    public Processo getById(Long id) {
        return super.getById(Processo.class, id);
    }

    public String getQuery(Processo filtro) {
        StringBuilder sql = new StringBuilder();
        sql.append("Processo o ");
        sql.append("where o.id > 0 ");
        if (filtro != null) {
            if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
                sql.append(" and o.descricao like '%").append(filtro.getDescricao()).append("%'");
            }
        }
        return sql.toString();
    }
}
