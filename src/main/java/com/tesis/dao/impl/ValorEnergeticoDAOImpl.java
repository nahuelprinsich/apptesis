package com.tesis.dao.impl;

import com.tesis.dao.ValorEnergeticoDAO;
import com.tesis.models.ValorEnergetico;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ValorEnergeticoDAOImpl extends GenericDAOImpl<ValorEnergetico> implements ValorEnergeticoDAO {

    public ValorEnergetico addValorEnergetico(ValorEnergetico valorEnergetico) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(valorEnergetico);
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
}
