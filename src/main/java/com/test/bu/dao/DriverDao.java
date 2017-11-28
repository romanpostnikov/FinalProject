package com.test.bu.dao;

import com.test.bu.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDao extends JpaRepository<Driver, Integer> {
    Driver findById(int id);

    Page<Driver> findAll(Pageable pageable);
}
