package com.tesis.dao;

import com.tesis.models.Producto;

/**
 * Created by Nahuel on 6/12/2017.
 */
public interface ProductoDAO extends GenericDAO<Producto> {

    public Producto getProductoById(Integer id);

    public Producto getProductoByCodigo(String codigo);
}
