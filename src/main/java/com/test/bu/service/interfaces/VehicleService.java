package com.test.bu.service.interfaces;

import com.test.bu.entity.Vehicle;
import org.springframework.data.domain.Page;

public interface VehicleService extends InterfaceService<Vehicle> {
    Page<Vehicle> findAll(int page, int size, String order);
}
