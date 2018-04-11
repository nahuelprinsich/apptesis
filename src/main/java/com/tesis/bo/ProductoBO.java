package com.tesis.bo;

import com.tesis.models.Producto;

import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public interface ProductoBO extends GenericBO<Producto> {

    public Producto getProductoById(Integer id);

    public Producto getProductoByCodigo(String codigo);

    List<Producto> getAllProductos();
}
