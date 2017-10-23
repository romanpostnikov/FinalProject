package com.test.bu.service.interfaces;

import com.test.bu.entity.Trip;
import org.springframework.data.domain.Page;

public interface TripService extends InterfaceService<Trip> {
    Page<Trip> findAll(int page, int size, String order);
}
