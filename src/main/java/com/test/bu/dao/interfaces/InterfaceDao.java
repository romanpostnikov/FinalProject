package com.test.bu.dao.interfaces;

import java.util.List;

public interface InterfaceDao<T> {
    void save(T entity);

    T getById(int id);

    T getById(String id);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);
}
