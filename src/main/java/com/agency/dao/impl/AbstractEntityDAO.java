package com.agency.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by vladimir on 12.04.2016.
 */
public abstract class AbstractEntityDAO<T> {
    @Autowired
    protected SessionFactory sessionFactory;

//    public Map<String, String> errors = new LinkedHashMap<String, String>();

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected abstract Class<T> getEntityClass();

    public void save(final T e) {
        getSession().save(e);
    }

    public void update(final T e) {
        getSession().update(e);
    }

    public void delete(final T e) {
        getSession().delete(e);
    }

    public void remove(final T e) {
        delete(e);
    }

    public T findById(final Long id) {
        return (T) getSession().get(getEntityClass(), id);
    }

    public List<T> findAll() {
        return getSession().createCriteria(getEntityClass()).list();
    }
}
