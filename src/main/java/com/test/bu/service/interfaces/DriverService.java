package com.test.bu.service.interfaces;

import com.test.bu.entity.Driver;
import org.springframework.data.domain.Page;

public interface DriverService extends InterfaceService<Driver> {
    Page<Driver> findAll(int page, int size, String order);
}
