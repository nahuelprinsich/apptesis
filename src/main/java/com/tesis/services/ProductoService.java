package com.tesis.services;

import com.tesis.models.Producto;

/**
 * Created by Nahuel on 14/1/2018.
 */
public interface ProductoService {

    public Producto getProductoById(Integer id);

    public Producto getProductoByCodigo(String codigo);
}
