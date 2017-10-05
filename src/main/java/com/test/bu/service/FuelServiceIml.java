package com.test.bu.service;

import com.test.bu.dao.interfaces.FuelDao;
import com.test.bu.entity.Fuel;
import com.test.bu.service.interfaces.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelServiceIml implements FuelService {
    @Autowired
    FuelDao fuelDao;

    @Override
    public void save(Fuel entity) {
        fuelDao.save(entity);
    }

    @Override
    public Fuel getById(int id) {
        return null;
    }

    @Override
    public Fuel getById(String id) {
        return fuelDao.getById(id);
    }

    @Override
    public List<Fuel> getAll() {
        return fuelDao.getAll();
    }

    @Override
    public void update(Fuel entity) {
        fuelDao.update(entity);
    }

    @Override
    public void delete(Fuel entity) {
        fuelDao.delete(entity);
    }
}
