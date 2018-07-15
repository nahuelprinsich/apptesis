package com.tesis.dao.impl;

import com.tesis.dao.GenericDAO;
import com.tesis.dao.ProductoValorEnergeticoDAO;
import com.tesis.models.ProductoValorEnergetico;

/**
 * Created by Nahuel on 9/7/2018.
 */
public class ProductoValorEnergeticoDAOImpl extends GenericDAOImpl<ProductoValorEnergetico> implements ProductoValorEnergeticoDAO {

    public ProductoValorEnergetico addProductoValorEnergetico(ProductoValorEnergetico productoValorEnergetico) {
        this.getSessionFactory().getCurrentSession().beginTransaction();
        this.getSessionFactory().getCurrentSession().save(productoValorEnergetico);
        this.getSessionFactory().getCurrentSession().getTransaction().commit();
        this.getSessionFactory().getCurrentSession().close();
        return productoValorEnergetico;
    }
}
