package com.test.bu.dao;

import com.test.bu.dao.interfaces.FuelDao;
import com.test.bu.entity.Fuel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FuelDaoIml implements FuelDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Fuel entity) {
        entityManager.persist(entity);
    }

    @Override
    public Fuel getById(int id) {
        return null;
    }

    @Override
    public Fuel getById(String id) {
        return entityManager.createQuery("SELECT f FROM Fuel f WHERE id=:id", Fuel.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Fuel> getAll() {
        return entityManager.createQuery("SELECT f FROM Fuel f", Fuel.class).getResultList();
    }

    @Override
    public void update(Fuel entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Fuel entity) {
        entityManager.remove(entity);
    }
}
