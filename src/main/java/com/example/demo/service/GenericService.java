package com.example.demo.service;

import java.util.List;

public interface GenericService<T, K> {

    List<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);

    T findById(K k);

}
