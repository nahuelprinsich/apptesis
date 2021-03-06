package com.tesis.dao.impl;

import com.tesis.dao.ProductoDAO;
import com.tesis.models.Producto;
import org.hibernate.*;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ProductoDAOImpl extends GenericDAOImpl<Producto> implements ProductoDAO {

    public Producto getProductoById(Integer id) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        Producto producto = new Producto();
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Producto.class);
            criteria.setFetchMode("envase",FetchMode.JOIN);
            criteria.setFetchMode("fabricante",FetchMode.JOIN);
            criteria.setFetchMode("usuario",FetchMode.JOIN);
            criteria.setFetchMode("comentarios",FetchMode.JOIN);
            criteria.setFetchMode("extras",FetchMode.JOIN);
            criteria.setFetchMode("ingredientes",FetchMode.JOIN);
            criteria.setFetchMode("productoValorEnergetico",FetchMode.JOIN);
            criteria.add(Restrictions.eq("id", id));
            criteria.add(Restrictions.eq("habilitado",true));
            producto = (Producto) criteria.uniqueResult();
            Hibernate.initialize(producto.getEnvase().getCaracteristicasEnvase().iterator().next().getEnvases());
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return producto;
    }

    public Producto getProductoByCodigo(String codigo) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        Producto producto = new Producto();
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Producto.class);
            criteria.setFetchMode("envase",FetchMode.JOIN);
            criteria.setFetchMode("fabricante",FetchMode.JOIN);
            criteria.setFetchMode("usuario",FetchMode.JOIN);
            criteria.setFetchMode("comentarios",FetchMode.JOIN);
            criteria.setFetchMode("extras",FetchMode.JOIN);
            criteria.setFetchMode("ingredientes",FetchMode.JOIN);
            criteria.setFetchMode("productoValorEnergetico",FetchMode.JOIN);
            criteria.add(Restrictions.eq("codigoBarra", codigo));
            criteria.add(Restrictions.eq("habilitado",true));
            producto = (Producto) criteria.uniqueResult();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return producto;
    }

    public List<Producto> getAllProductos() {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<Producto> lista;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Producto.class);
            criteria.setFetchMode("envase",FetchMode.JOIN);
            criteria.setFetchMode("fabricante",FetchMode.JOIN);
            criteria.setFetchMode("usuario",FetchMode.JOIN);
            criteria.setFetchMode("comentarios",FetchMode.JOIN);
            criteria.setFetchMode("extras",FetchMode.JOIN);
            criteria.setFetchMode("ingredientes",FetchMode.JOIN);
            criteria.setFetchMode("productoValorEnergetico",FetchMode.JOIN);
            criteria.add(Restrictions.eq("habilitado",true));
            lista = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return lista;
    }

    public  List<Producto> getByRubro(String rubro){

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<Producto> lista;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Producto.class);
            criteria.add(Restrictions.eq("rubro", rubro));
            criteria.add(Restrictions.eq("habilitado",true));
            lista = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return lista;
    }

    public List<Producto> getAllByIngrediente(List<String> ingredientes) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<Producto> lista;
        List<String> ing = new ArrayList<String>();
        for (String ingrediente: ingredientes) {
            ing.add(ingrediente.replace("*", " "));
        }
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Producto.class, "producto");
            criteria.createAlias("producto.ingredientes", "ingrediente");
            criteria.add(Restrictions.in("ingrediente.nombre", ing));
            criteria.add(Restrictions.eq("habilitado",true));
            lista = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return lista;
    }

    public Producto addProducto(Producto producto){

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(producto);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return producto;
    }

    public ArrayList getRubros() {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList lista;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT rubro,tipoRubro,idProducto FROM Producto GROUP BY rubro ORDER BY rubro ASC";
            Query query = session.createQuery(hql);
            lista = (ArrayList) query.list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return lista;
    }

    public ArrayList getProductosByRuInEx(String rubro, List<Integer> ingredientes, List<Integer> extras, String opcion) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList lista;
        String hql;
        Query query = null;
        rubro = rubro.replace("_"," ");

        try {
            tx = session.beginTransaction();
            if (opcion.equals("r00")) {
                hql = "SELECT distinct p.codigoBarra, p.rubro, p.tipoRubro, p.urlImagen, p.contenidoNeto, p.nombreProducto, p.marca " +
                        "FROM Producto p " +
                        "WHERE p.rubro = :rubro AND p.habilitado = true";
                query = session.createQuery(hql)
                        .setParameter("rubro",rubro);
            } else if (opcion.equals("rii")) {
                hql = "SELECT distinct p.codigoBarra, p.rubro, p.tipoRubro, p.urlImagen, p.contenidoNeto, p.nombreProducto, p.marca " +
                        "FROM Producto p INNER JOIN p.ingredientes i " +
                        "INNER JOIN p.extras e " +
                        "WHERE p.rubro = :rubro AND i.idIngrediente IN (:ingredientes) AND e.idExtra IN (:extras) AND p.habilitado = true";
                query = session.createQuery(hql)
                        .setParameter("rubro",rubro)
                        .setParameterList("ingredientes",ingredientes)
                        .setParameterList("extras",extras);
            } else if (opcion.equals("ri0")) {
                hql = "SELECT distinct p.codigoBarra, p.rubro, p.tipoRubro, p.urlImagen, p.contenidoNeto, p.nombreProducto, p.marca " +
                        "FROM Producto p INNER JOIN p.ingredientes i " +
                        "WHERE p.rubro = :rubro AND i.idIngrediente IN (:ingredientes) AND p.habilitado = true";
                query = session.createQuery(hql)
                        .setParameter("rubro",rubro)
                        .setParameterList("ingredientes",ingredientes);
            } else if (opcion.equals("rei")) {
                hql = "SELECT distinct p.codigoBarra, p.rubro, p.tipoRubro, p.urlImagen, p.contenidoNeto, p.nombreProducto, p.marca " +
                        "FROM Producto p " +
                        "INNER JOIN p.extras e " +
                        "WHERE p.rubro = :rubro AND e.idExtra IN (:extras) AND p.habilitado = true AND p.idProducto NOT IN " +
                        "(SELECT p1.idProducto FROM Producto p1 INNER JOIN p1.ingredientes i WHERE i.idIngrediente IN (:ingredientes) )";
                query = session.createQuery(hql)
                        .setParameter("rubro",rubro)
                        .setParameterList("ingredientes",ingredientes)
                        .setParameterList("extras",extras);
            } else if (opcion.equals("re0")) {
                hql = "SELECT distinct p.codigoBarra, p.rubro, p.tipoRubro, p.urlImagen, p.contenidoNeto, p.nombreProducto, p.marca " +
                        "FROM Producto p " +
                        "WHERE p.rubro = :rubro AND p.habilitado = true AND p.idProducto NOT IN " +
                        "(SELECT p1.idProducto FROM Producto p1 INNER JOIN p1.ingredientes i WHERE i.idIngrediente IN (:ingredientes))";
                query = session.createQuery(hql)
                        .setParameterList("ingredientes",ingredientes)
                        .setParameter("rubro",rubro);
            } else if (opcion.equals("r0i")) {
                hql = "SELECT distinct p.codigoBarra, p.rubro, p.tipoRubro, p.urlImagen, p.contenidoNeto, p.nombreProducto, p.marca " +
                        "FROM Producto p INNER JOIN p.extras e " +
                        "WHERE p.rubro = :rubro AND e.idExtra IN (:extras) AND p.habilitado = true";
                query = session.createQuery(hql)
                        .setParameter("rubro",rubro)
                        .setParameterList("extras",extras);
            }

            lista = (ArrayList) query.list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return lista;
    }

    public void eliminarProducto(Integer idProducto) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList lista;
        try {
            tx = session.beginTransaction();
            String hql = "UPDATE Producto SET habilitado = false WHERE idProducto = :id";
            Query query = session.createQuery(hql).setParameter("id",idProducto);
            query.executeUpdate();
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
