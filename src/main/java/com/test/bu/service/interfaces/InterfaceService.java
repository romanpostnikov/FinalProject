package com.test.bu.service.interfaces;

import java.util.Collection;

public interface InterfaceService<T> {
    T save(T entity);

    T findById(int id);

    Collection<T> findAll();

    void delete(int id);
}
