package com.tesis.dao.impl;

import com.tesis.dao.GenericDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;
    protected Class<T> daoType;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(T entity) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
             session.save(entity);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }

    public void saveOrUpdate(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void update(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    public void remove(T entity) {
        currentSession().delete(entity);
    }

    public T find(T key) {
        return null;
    }

    public List<T> getAll(Class<T> type) {
        List<T> lista;
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(type);
            lista = criteria.list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return lista;
    }

    public Class<T> getDaoType() {
        return daoType;
    }

    public void setDaoType(Class<T> daoType) {
        this.daoType = daoType;
    }
}
