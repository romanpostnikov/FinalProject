package com.test.bu.dao;

import com.test.bu.dao.interfaces.TripDao;
import com.test.bu.entity.Trip;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TripDaoIml implements TripDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Trip entity) {
        entityManager.persist(entity);
    }

    @Override
    public Trip getById(int id) {
        return entityManager.createQuery("SELECT t FROM Trip t WHERE id=:id", Trip.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Trip getById(String id) {
        return null;
    }

    @Override
    public List<Trip> getAll() {
        return entityManager.createQuery("SELECT t FROM Trip t", Trip.class).getResultList();
    }

    @Override
    public void update(Trip entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Trip entity) {
        entityManager.remove(entity);
    }
}
