package com.test.bu.dao;

import com.test.bu.dao.interfaces.VehicleDao;
import com.test.bu.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class VehicleDaoIml implements VehicleDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Vehicle entity) {
        entityManager.persist(entity);
    }

    @Override
    public Vehicle getById(int id) {
        return entityManager.createQuery("SELECT v FROM Vehicle v WHERE id=:id", Vehicle.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Vehicle getById(String id) {
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return entityManager.createQuery("SELECT v FROM Vehicle v", Vehicle.class).getResultList();
    }

    @Override
    public void update(Vehicle entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Vehicle entity) {
        entityManager.remove(entity);
    }
}
