package com.test.bu.service;

import com.test.bu.dao.interfaces.UserDao;
import com.test.bu.entity.User;
import com.test.bu.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void save(User entity) {
        userDao.save(entity);
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User getById(String id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public void delete(int id) {}

    @Override
    public void delete(String id) {
        userDao.delete(userDao.getById(id));
    }
}
