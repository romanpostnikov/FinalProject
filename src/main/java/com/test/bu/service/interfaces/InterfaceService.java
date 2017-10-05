package com.test.bu.service.interfaces;

import java.util.List;

public interface InterfaceService<T> {
    void save(T entity);

    T getById(int id);

    T getById(String id);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}
