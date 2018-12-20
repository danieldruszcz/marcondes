/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danieldruszcz
 */
public class Conexao {

    private EntityManagerFactory factory = null;
    private EntityManager entityManager = null;

    public EntityManager getEntityManager() {
        factory = Persistence.createEntityManagerFactory("gerenciadorWsPU");
        entityManager = factory.createEntityManager();
        return entityManager;
    }
    
    public void finalize(){
        entityManager.close();
        factory.close();
    }
}
