package com.tesis.dao.impl;

import com.tesis.dao.ValorEnergeticoDAO;
import com.tesis.models.ValorEnergetico;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ValorEnergeticoDAOImpl extends GenericDAOImpl<ValorEnergetico> implements ValorEnergeticoDAO {

    public ValorEnergetico addValorEnergetico(ValorEnergetico valorEnergetico) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(valorEnergetico);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return valorEnergetico;
    }

    public List<ValorEnergetico> getAllValoresEnergeticos() {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<ValorEnergetico> lista;
        try {
            tx = session.beginTransaction();
            lista = session.createCriteria(ValorEnergetico.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
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
