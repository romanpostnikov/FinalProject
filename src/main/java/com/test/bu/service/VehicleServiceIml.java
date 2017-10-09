package com.test.bu.service;

import com.test.bu.dao.interfaces.VehicleDao;
import com.test.bu.entity.Vehicle;
import com.test.bu.service.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceIml implements VehicleService {
    @Autowired
    VehicleDao vehicleDao;

    @Override
    public void save(Vehicle entity) {
        vehicleDao.save(entity);
    }

    @Override
    public Vehicle getById(int id) {
        return vehicleDao.getById(id);
    }

    @Override
    public Vehicle getById(String id) {
        return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleDao.getAll();
    }

    @Override
    public void update(Vehicle entity) {
        vehicleDao.update(entity);
    }

    @Override
    public void delete(int id) {
        vehicleDao.delete(vehicleDao.getById(id));
    }

    @Override
    public void delete(String id) {
    }
}
