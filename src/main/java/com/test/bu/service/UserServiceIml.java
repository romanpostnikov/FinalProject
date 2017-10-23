package com.test.bu.service;

import com.test.bu.dao.UserDao;
import com.test.bu.entity.User;
import com.test.bu.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceIml implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceIml.class);
    @Autowired
    UserDao userDao;

    @Override
    public User save(User user) {
        userDao.save(user);
        return user;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(String username) {
        userDao.delete(userDao.findByUsername(username));
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
