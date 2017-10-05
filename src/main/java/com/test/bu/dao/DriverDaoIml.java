package com.test.bu.dao;

import com.test.bu.dao.interfaces.DriverDao;
import com.test.bu.entity.Driver;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DriverDaoIml implements DriverDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Driver entity) {
        entityManager.persist(entity);
    }

    @Override
    public Driver getById(int id) {
        return entityManager.createQuery("SELECT d FROM Driver d WHERE id=:id", Driver.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Driver getById(String id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return entityManager.createQuery("SELECT d FROM Driver d", Driver.class).getResultList();
    }

    @Override
    public void update(Driver entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Driver entity) {
        entityManager.remove(entity);

    }
}
