package com.tesis.dao;

import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public interface GenericDAO<T> {

    public void add(T entity) ;
    public void saveOrUpdate(T entity) ;
    public void update(T entity) ;
    public void remove(T entity);
    public T find(T key);
    public List<T> getAll(Class<T> type) ;

}
