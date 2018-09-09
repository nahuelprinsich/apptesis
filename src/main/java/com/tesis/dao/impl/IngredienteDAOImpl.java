package com.tesis.dao.impl;

import com.tesis.dao.IngredienteDAO;
import com.tesis.models.Ingrediente;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class IngredienteDAOImpl extends GenericDAOImpl<Ingrediente> implements IngredienteDAO {

    public List<Ingrediente> getAllIngredientes() {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<Ingrediente> lista;
        try {
            tx = session.beginTransaction();
            lista = session.createCriteria(Ingrediente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
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

    public Ingrediente addIngrediente(Ingrediente ingrediente) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(ingrediente);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return ingrediente;
    }

    public List<Ingrediente> getIngredienteByName(String nombreIngrediente) {

        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        List<Ingrediente> ingredientes;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Ingrediente.class);
            criteria.add(Restrictions.like("nombre", nombreIngrediente + '%'));
            criteria.setMaxResults(5);
            ingredientes = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return ingredientes;
    }

    public ArrayList getIngredientesByTipoRubro(String tipoRubro) {

        /*Session session = getSessionFactory().openSession();
        Transaction tx = null;
        List<Ingrediente> ingredientes;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Ingrediente.class);
            criteria.add(Restrictions.like("tipoRubro", tipoRubro + '%'));
            criteria.addOrder(Order.asc("nombre"));
            ingredientes = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return ingredientes;*/

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList lista;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT idIngrediente, nombre FROM Ingrediente WHERE tipoRubro = :tipoR GROUP BY nombre ORDER BY nombre ASC";
            Query query = session.createQuery(hql).setParameter("tipoR", tipoRubro);
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
}