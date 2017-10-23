package com.test.bu.service;

import com.test.bu.dao.DriverDao;
import com.test.bu.entity.Driver;
import com.test.bu.service.interfaces.DriverService;
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
public class DriverServiceIml implements DriverService {

    private static final Logger logger = Logger.getLogger(DriverServiceIml.class);

    @Autowired
    DriverDao driverDao;

    @Override
    public Driver save(Driver driver) {
        driverDao.save(driver);
        return driver;
    }

    @Override
    public void delete(int id) {
        driverDao.delete(driverDao.findById(id));
    }

    @Override
    public Page<Driver> findAll(int page, int size, String order) {
        if (StringUtils.isEmpty(order)) {
            order = "id";
        }
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, order));
        Pageable pageable = new PageRequest(page, size, sort);
        return driverDao.findAll(pageable);
    }

    @Override
    public Collection<Driver> findAll() {
        List<Driver> result;
        try {
            result = driverDao.findAll();
        } catch (Exception e) {
            logger.error("Something wrong with findAll in DriverService", e);
            result = Collections.EMPTY_LIST;
        }
        return result;
    }

    @Override
    public Driver findById(int id) {
        return driverDao.findById(id);
    }
}
