package com.tesis.dao.impl;

import com.tesis.dao.GenericDAO;
import com.tesis.dao.ProductoValorEnergeticoDAO;
import com.tesis.models.ProductoValorEnergetico;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Nahuel on 9/7/2018.
 */
public class ProductoValorEnergeticoDAOImpl extends GenericDAOImpl<ProductoValorEnergetico> implements ProductoValorEnergeticoDAO {

    public ProductoValorEnergetico addProductoValorEnergetico(ProductoValorEnergetico productoValorEnergetico) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(productoValorEnergetico);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return productoValorEnergetico;
    }

    public void borrarProductoValorEnergetico(ProductoValorEnergetico productoValorEnergetico) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(productoValorEnergetico);
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
}
