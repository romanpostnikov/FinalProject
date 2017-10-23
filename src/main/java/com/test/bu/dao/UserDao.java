package com.test.bu.dao;

import com.test.bu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer>{
    User findByUsername(String username);

    List<User> findAll();

    @Override
    void delete(User user);

    @Override
    User save(User user);
}
