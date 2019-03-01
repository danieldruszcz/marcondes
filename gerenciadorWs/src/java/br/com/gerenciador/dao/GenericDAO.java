/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciador.dao;

import br.com.gerenciador.entity.Processo;
import br.com.gerenciador.util.Conexao;
import br.com.gerenciador.util.Paginator;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
        } catch (Exception e) {
            e.printStackTrace();
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
    
    
    @SuppressWarnings("unchecked")
    public Integer count(T filtro) {
        Integer count = (int) (long) getEntityManager().createQuery("select count(o.id) from " + this.getQuery(filtro)).getSingleResult();
        return count != null ? count : 0;
    }
    
    protected List<T> getPaginatedItens(String query, int first, int itensPPage){
        Query q = this.getEntityManager().createQuery(query);
        q.setFirstResult(first);
        q.setMaxResults(itensPPage);
        return q.getResultList();
    }

    public EntityManager getEntityManager() {

        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao.getEntityManager();
    }

    protected Object selectUnique(String query) {
        try {
            System.out.println("Query " + query);
            return getEntityManager().createQuery(query).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    protected String removerCaracterEspecial(String x){
        return x.replaceAll("'", "");
    }
    
     public List<T> pesquisar(Paginator paginator) {
        T filtro = (T) paginator.getFilter();
        return this.getPaginatedItens("select o from " + this.getQuery(filtro) + " order by o.id", paginator.getFirst(), paginator.getItensPPage());
    }
    
    protected abstract String getQuery(T filtro);

}
