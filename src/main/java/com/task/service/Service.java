package com.task.service;

import java.util.List;

/**
 * Created by Antony on 11.07.2016.
 */
public interface Service<T> {
    public List<T> getAll();
    public T get(Integer id );
    public void add(T person);
    public void delete(Integer id);
}
