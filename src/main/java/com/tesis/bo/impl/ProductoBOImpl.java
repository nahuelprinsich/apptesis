package com.tesis.bo.impl;

import com.tesis.bo.ProductoBO;
import com.tesis.dao.ProductoDAO;
import com.tesis.models.Producto;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ProductoBOImpl extends GenericBOImpl<Producto> implements ProductoBO {

    private ProductoDAO productoDAO;

    public ProductoDAO getProductoDAO() { return productoDAO; }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public Producto getProductoById(Integer id) {
        return productoDAO.getProductoById(id);
    }
}
