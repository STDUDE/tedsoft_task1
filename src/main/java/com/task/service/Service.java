package com.task.service;

import java.util.List;

public interface Service<T> {
    public List<T> getAll();
    public T get(Integer id );
    public void add(T person);
    public void delete(Integer id);
}
