package com.test.bu.service;

import com.test.bu.dao.VehicleDao;
import com.test.bu.entity.Vehicle;
import com.test.bu.service.interfaces.VehicleService;
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
public class VehicleServiceIml implements VehicleService {
    private static final Logger logger = Logger.getLogger(VehicleServiceIml.class);

    @Autowired
    VehicleDao vehicleDao;

    @Override
    public void save(Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    @Override
    public void delete(int id) {
        vehicleDao.delete(vehicleDao.findById(id));
    }

    @Override
    public Page<Vehicle> findAll(int page, int size, String order) {
        if (StringUtils.isEmpty(order)) {
            order = "id";
        }
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, order));
        Pageable pageable = new PageRequest(page, size, sort);
        return vehicleDao.findAll(pageable);
    }

    @Override
    public Collection<Vehicle> findAll() {
        List<Vehicle> result;
        try {
            result = vehicleDao.findAll();
        } catch (Exception e) {
            logger.error("Something wrong with findAll in VehicleService", e);
            result = Collections.EMPTY_LIST;
        }
        return result;
    }

    @Override
    public Vehicle findById(int id) {
        return vehicleDao.findById(id);
    }
}
