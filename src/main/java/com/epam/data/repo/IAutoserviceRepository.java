package com.epam.data.repo;

import java.util.List;

public interface IAutoserviceRepository<T extends Object> {
    void add(T object);

    T find(T object);

    void delete(T object);

    List<T> findAll();
}
