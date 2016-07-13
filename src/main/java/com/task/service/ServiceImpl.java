package com.task.service;

import com.task.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Antony on 11.07.2016.
 */

public class ServiceImpl<T> implements Service<T>{
    final Class<T> typeParameterClass;

    public ServiceImpl(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public List<T> getAll() {
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery("FROM " + typeParameterClass.getName());
        return  query.list();
    }

    public T get(Integer id ) {
        Session session = HibernateUtil.openSession();
        T item = (T) session.get(typeParameterClass.getName(), id);
        return item;
    }
    public void add(T item) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }

    public void delete(Integer id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.delete(this.get(id));
        session.getTransaction().commit();
    }

}
