/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.util.Conexao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author danieldruszcz
 */
public abstract class GenericDAO<T, I extends Serializable> {

    private Conexao conexao;

    public T save(T entity) {

        T saved = null;
        try {

            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            saved = em.merge(entity);
            em.getTransaction().commit();
        } finally {
            this.conexao.finalize();
        }

        return saved;
    }

    public void remove(T entity) {
        try {
            EntityManager em = this.getEntityManager();
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            this.conexao.finalize();
        }

    }

    public T getById(Class<T> classe, I pk) {

        try {
            return getEntityManager().find(classe, pk);
        } catch (NoResultException e) {
            return null;
        } finally {
            conexao.finalize();
        }

    }

    @SuppressWarnings("unchecked")
    public List<T> getAll(Class<T> classe) {

        return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
    }

    public EntityManager getEntityManager() {

        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao.getEntityManager();
    }

}
