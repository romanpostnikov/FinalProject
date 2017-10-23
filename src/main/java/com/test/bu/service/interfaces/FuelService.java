package com.test.bu.service.interfaces;

import com.test.bu.entity.Fuel;

public interface FuelService extends InterfaceService<Fuel> {
    Fuel findByFuelType(String fuelType);
    void delete(String id);
}
