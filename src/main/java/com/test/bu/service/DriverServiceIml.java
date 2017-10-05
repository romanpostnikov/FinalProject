package com.test.bu.service;

import com.test.bu.dao.interfaces.DriverDao;
import com.test.bu.entity.Driver;
import com.test.bu.service.interfaces.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceIml implements DriverService {
    @Autowired
    DriverDao driverDao;

    @Override
    public void save(Driver entity) {
        driverDao.save(entity);
    }

    @Override
    public Driver getById(int id) {
        return driverDao.getById(id);
    }

    @Override
    public Driver getById(String id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public void update(Driver entity) {
        driverDao.update(entity);
    }

    @Override
    public void delete(Driver entity) {
        driverDao.delete(entity);
    }
}
