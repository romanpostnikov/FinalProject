package com.test.bu.service;

import com.test.bu.dao.FuelDao;
import com.test.bu.entity.Fuel;
import org.apache.log4j.Logger;
import com.test.bu.service.interfaces.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelServiceIml implements FuelService {

    private final static Logger logger = Logger.getLogger(FuelServiceIml.class);
    @Autowired
    FuelDao fuelDao;

    @Override
    public void save(Fuel fuel) {
        fuelDao.save(fuel);
    }

    @Override
    public Fuel findByFuelType(String fuelType) {
        return fuelDao.findByFuelType(fuelType);
    }

    @Override
    public List<Fuel> findAll() {
        return fuelDao.findAll();
    }

    @Override
    public void delete(String fuelType) {
        fuelDao.delete(fuelDao.findByFuelType(fuelType));
    }

    @Override
    public Fuel findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
