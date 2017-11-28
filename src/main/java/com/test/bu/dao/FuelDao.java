package com.test.bu.dao;

import com.test.bu.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelDao extends JpaRepository<Fuel, Integer> {
    Fuel findByFuelType(String fuelType);

    List<Fuel> findAll();
}
