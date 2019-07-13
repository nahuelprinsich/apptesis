package com.tesis.bo.impl;

import com.tesis.bo.GenericBO;
import com.tesis.dao.GenericDAO;

import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class GenericBOImpl<T> implements GenericBO<T> {

    private GenericDAO<T> genericDAO;

    public GenericDAO<T> getGenericDAO() {
        return genericDAO;
    }

    public void setGenericDAO(GenericDAO<T> genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void add(T entity) {
        genericDAO.add(entity);
    }

    public void saveOrUpdate(T entity) {
        genericDAO.saveOrUpdate(entity);
    }

    public void update(T entity) {
        genericDAO.update(entity);
    }

    public void remove(T entity) {
        genericDAO.remove(entity);
    }

    public T find(T key) {
        return null;
    }

    public List<T> getAll(Class<T> type) {
        return genericDAO.getAll(type);
    }
}
