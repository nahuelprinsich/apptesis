package com.tesis.dao.impl;

import com.tesis.dao.ProductoDAO;
import com.tesis.models.Producto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ProductoDAOImpl extends GenericDAOImpl<Producto> implements ProductoDAO {

    public Producto getProductoById(Integer id) {
        Producto producto = new Producto();
        this.getSessionFactory().getCurrentSession().beginTransaction();
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Producto.class);
        criteria.add(Restrictions.eq("id", id));
        producto = (Producto) criteria.uniqueResult();
        this.getSessionFactory().getCurrentSession().close();
        return producto;
    }

    public Producto getProductoByCodigo(String codigo) {
        Producto producto = new Producto();
        this.getSessionFactory().getCurrentSession().beginTransaction();
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigoBarra", codigo));
        producto = (Producto) criteria.uniqueResult();
        this.getSessionFactory().getCurrentSession().close();
        return producto;
    }

    public List<Producto> getAllProductos() {
        List<Producto> lista;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Producto.class);
        lista = criteria.list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }


}
