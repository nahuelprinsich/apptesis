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
        lista = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }

    public  List<Producto> getByRubro(String rubro){
        List<Producto> lista;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Producto.class);
        criteria.add(Restrictions.eq("rubro", rubro));
        lista = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }

    public List<Producto> getAllByIngrediente(List<String> ingredientes) {
        List<Producto> lista;
        List<String> ing = new ArrayList<String>();
        for (String ingrediente: ingredientes) {
            ing.add(ingrediente.replace("*", " "));
        }
        this.getSessionFactory().getCurrentSession().beginTransaction();
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Producto.class, "producto");
        criteria.createAlias("producto.ingredientes", "ingrediente");
        criteria.add(Restrictions.in("ingrediente.nombre", ing));
        lista = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }


}
