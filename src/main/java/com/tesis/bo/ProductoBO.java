package com.tesis.bo;

import com.tesis.models.Producto;

/**
 * Created by Nahuel on 6/12/2017.
 */
public interface ProductoBO extends GenericBO<Producto> {

    public Producto getProductoById(Integer id);
}
