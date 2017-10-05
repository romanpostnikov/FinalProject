package com.test.bu.service;

import com.test.bu.dao.interfaces.TripDao;
import com.test.bu.entity.Trip;
import com.test.bu.service.interfaces.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceIml implements TripService {
    @Autowired
    TripDao tripDao;

    @Override
    public void save(Trip entity) {
        tripDao.save(entity);
    }

    @Override
    public Trip getById(int id) {
        return tripDao.getById(id);
    }

    @Override
    public Trip getById(String id) {
        return null;
    }

    @Override
    public List<Trip> getAll() {
        return tripDao.getAll();
    }

    @Override
    public void update(Trip entity) {
        tripDao.update(entity);
    }

    @Override
    public void delete(Trip entity) {
        tripDao.delete(entity);
    }
}
