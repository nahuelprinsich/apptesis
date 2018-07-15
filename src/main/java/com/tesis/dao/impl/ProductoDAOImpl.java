package com.tesis.dao.impl;

import com.tesis.dao.ProductoDAO;
import com.tesis.models.Producto;
import org.hibernate.Criteria;
import org.hibernate.Query;
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

    public Producto addProducto(Producto producto){
        this.getSessionFactory().getCurrentSession().beginTransaction();
        this.getSessionFactory().getCurrentSession().saveOrUpdate(producto);
        this.getSessionFactory().getCurrentSession().getTransaction().commit();
        this.getSessionFactory().getCurrentSession().close();
        return producto;
    }

    public ArrayList getRubros() {
        ArrayList lista;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        String hql = "SELECT distinct rubro,tipoRubro,idProducto FROM Producto";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        lista = (ArrayList) query.list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }

    public List<Producto> getProductosByRuInEx(String rubro, List<Integer> ingredientes, List<Integer> extras, String opcion) {
        List<Producto> lista;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        String hql;
        Query query = null;
        if (opcion.equals("r00")) {
            hql = "SELECT distinct p " +
                    "FROM Producto p " +
                    "WHERE p.rubro = :rubro";
            query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                    .setParameter("rubro",rubro);
        } else if (opcion.equals("rii")) {
            hql = "SELECT distinct p " +
                    "FROM Producto p INNER JOIN p.ingredientes i " +
                    "INNER JOIN p.extras e " +
                    "WHERE p.rubro = :rubro AND i.idIngrediente IN (:ingredientes) AND e.idExtra IN (:extras)";
            query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                    .setParameter("rubro",rubro)
                    .setParameterList("ingredientes",ingredientes)
                    .setParameterList("extras",extras);
        } else if (opcion.equals("ri0")) {
            hql = "SELECT distinct p " +
                    "FROM Producto p INNER JOIN p.ingredientes i " +
                    "WHERE p.rubro = :rubro AND i.idIngrediente NOT IN (:ingredientes)";
            query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                    .setParameter("rubro",rubro)
                    .setParameterList("ingredientes",ingredientes);
        } else if (opcion.equals("rei")) {
            hql = "SELECT distinct p " +
                    "FROM Producto p INNER JOIN p.ingredientes i " +
                    "INNER JOIN p.extras e " +
                    "WHERE p.rubro = :rubro AND i.idIngrediente NOT IN (:ingredientes) AND e.idExtra IN (:extras)";
            query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                    .setParameter("rubro",rubro)
                    .setParameterList("ingredientes",ingredientes)
                    .setParameterList("extras",extras);
        } else if (opcion.equals("re0")) {
            hql = "SELECT distinct p " +
                    "FROM Producto p INNER JOIN p.ingredientes i " +
                    "WHERE p.rubro = :rubro AND i.idIngrediente NOT IN (:ingredientes)";
            query = this.getSessionFactory().getCurrentSession().createQuery(hql)
                    .setParameter("rubro",rubro)
                    .setParameterList("ingredientes",ingredientes);
        }

        lista = query.list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }

}
