package com.example.demo24.services;

import java.util.List;

public interface TableService<T> {
    void createEntity(T t);

    List<T> readAllEntity();

    T readOneEntity(long id);

    boolean updateEntity(T t, long id);

    boolean deleteEntity(long id);
}
