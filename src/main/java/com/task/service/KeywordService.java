package com.task.service;

import com.task.domain.Classes;
import com.task.domain.Keywords;
import com.task.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class KeywordService extends ServiceImpl{

    List<Keywords> list;
    StringBuilder response;

    public KeywordService(Class typeParameterClass) {
        super(typeParameterClass);
        list = null;
        response = new StringBuilder();
    }

    public void toggle(){
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        boolean toggle = list.get(0).getBinded_class().isStatus();
        Classes existingClass = (Classes) session.get(Classes.class, list.get(0).getBinded_class().getId());
        existingClass.setStatus(!toggle);
        session.save(existingClass);
        session.getTransaction().commit();
        response.append(list.get(0).getBinded_class().getClassName()).append(": ");
        response.append(existingClass.isStatus() ? "I am turned on!" : "I am turned off!");
    }

    public String getResponse() {
        return response.toString();
    }

    public boolean isExist(String keyword) {
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery("from Keywords where keyword = :keyword ");
        query.setParameter("keyword", keyword);
        list = query.list();
        if(list == null || list.size() == 0) return false;
        else return true;
    }
}
