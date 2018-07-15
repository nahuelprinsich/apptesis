package com.tesis.bo.impl;

import com.tesis.bo.GenericBO;
import com.tesis.bo.ProductoValorEnergeticoBO;
import com.tesis.dao.ProductoValorEnergeticoDAO;
import com.tesis.models.ProductoValorEnergetico;

/**
 * Created by Nahuel on 9/7/2018.
 */
public class ProductoValorEnergeticoBOImpl extends GenericBOImpl<ProductoValorEnergetico> implements ProductoValorEnergeticoBO {

    private ProductoValorEnergeticoDAO productoValorEnergeticoDAO;

    public ProductoValorEnergeticoDAO getProductoValorEnergeticoDAO() {
        return productoValorEnergeticoDAO;
    }

    public void setProductoValorEnergeticoDAO(ProductoValorEnergeticoDAO productoValorEnergeticoDAO) {
        this.productoValorEnergeticoDAO = productoValorEnergeticoDAO;
    }

    public ProductoValorEnergetico addProductoValorEnergetico(ProductoValorEnergetico productoValorEnergetico) {
        return  this.productoValorEnergeticoDAO.addProductoValorEnergetico(productoValorEnergetico);
    }
}
