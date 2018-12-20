/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Usuario;
import br.com.gerenciador.util.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danieldruszcz
 */
public class UsuarioDAO {
    
    
    public Usuario login(String usuario, String senha){
        try {
            return (Usuario) Util.readJsonFromUrl(("usuario/login/" + usuario + "/" + senha), Usuario.class);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
