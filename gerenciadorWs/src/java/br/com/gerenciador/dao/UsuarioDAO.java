/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Usuario;
import java.util.List;

/**
 *
 * @author danieldruszcz
 */
public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    public Usuario getById(Long id) {
        return super.getById(Usuario.class, id);
    }

    public Usuario getUser(String login, String senha) {
        String query = "from Usuario as user"
                + " where user.usuario = '" + login + "' and"
                + " user.senha = '" + senha + "'";
        return (Usuario) this.selectUnique(query);
    }

    @Override
    protected String getQuery(Usuario filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
