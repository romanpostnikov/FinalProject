package com.test.bu.dao;

import com.test.bu.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle, Integer>{
    Vehicle findById(int id);

    Page<Vehicle> findAll(Pageable pageable);

    @Override
    void delete(Vehicle vehicle);

    @Override
    Vehicle save(Vehicle vehicle);
}
