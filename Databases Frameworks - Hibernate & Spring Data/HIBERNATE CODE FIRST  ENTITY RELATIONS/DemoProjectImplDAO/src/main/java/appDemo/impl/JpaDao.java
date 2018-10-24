package appDemo.impl;

import appDemo.daoApi.Dao;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaDao<E, K> implements Dao<E, K> {

    private EntityManager entityManager;

    public JpaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public E findById(Class<E> entityClass, K primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<E> findAll(Class<E> entityClass) {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName()).getResultList();
    }

    @Override
    public void save(E entity) {
        entityManager.persist(entity);
    }
}
