package com.test.bu.dao;

import com.test.bu.dao.interfaces.UserDao;
import com.test.bu.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoIml implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(User entity) {
        entityManager.persist(entity);
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User getById(String id) {
        return entityManager.createQuery("SELECT u FROM User u WHERE id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void update(User entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(User entity) {
        entityManager.remove(entity);
    }
}
