package com.test.bu.dao;

import com.test.bu.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripDao extends JpaRepository<Trip, Integer>{
    Trip findById(int id);

    Page<Trip> findAll(Pageable pageable);

    @Override
    void delete(Trip trip);

    @Override
    Trip save(Trip trip);
}
