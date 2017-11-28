package com.test.bu.service;

import com.test.bu.dao.TripDao;
import com.test.bu.entity.Trip;
import com.test.bu.service.interfaces.TripService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class TripServiceIml implements TripService {

    private static final Logger logger = Logger.getLogger(TripServiceIml.class);

    @Autowired
    TripDao tripDao;

    @Override
    public void save(Trip trip) {
        tripDao.save(trip);
    }

    @Override
    public void delete(int id) {
        tripDao.delete(tripDao.findById(id));
    }

    @Override
    public Page<Trip> findAll(int page, int size, String order) {
        if (StringUtils.isEmpty(order)) {
            order = "id";
        }
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, order));
        Pageable pageable = new PageRequest(page, size, sort);
        return tripDao.findAll(pageable);
    }

    @Override
    public Collection<Trip> findAll() {
        List<Trip> result;
        try {
            result = tripDao.findAll();
        } catch (Exception e) {
            logger.error("Something wrong with findAll in TripService", e);
            result = Collections.EMPTY_LIST;
        }
        return result;
    }

    @Override
    public Trip findById(int id) {
        return tripDao.findById(id);
    }
}
