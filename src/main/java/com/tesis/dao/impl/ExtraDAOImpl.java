package com.tesis.dao.impl;

import com.tesis.dao.ExtraDAO;
import com.tesis.models.Extra;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public List<Extra> getAllExtras() {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<Extra> lista;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Extra.class);
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
}
