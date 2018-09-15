package com.tesis.dao.impl;

import com.tesis.dao.ExtraDAO;
import com.tesis.models.Extra;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ExtraDAOImpl extends GenericDAOImpl<Extra> implements ExtraDAO {

    public Extra addExtra(Extra extra) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(extra);;
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return extra;
    }

    public ArrayList getAllExtras() {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        ArrayList lista;
        try {
            tx = session.beginTransaction();
            String hql = "SELECT idExtra, descripcion, urlLogo FROM Extra GROUP BY descripcion ORDER BY descripcion ASC";
            Query query = session.createQuery(hql);
            lista = (ArrayList) query.list();
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return lista;
    }

    public List<Extra> getAllExtrasTabla(){
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<Extra> lista;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Extra.class);
            criteria.addOrder(Order.asc("descripcion"));
            System.out.println("Se consulta a la base");
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
        System.out.println("Se retorna el resultado");
        return lista;
    }
}
