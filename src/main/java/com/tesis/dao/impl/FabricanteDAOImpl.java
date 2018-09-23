package com.tesis.dao.impl;

import com.tesis.dao.FabricanteDAO;
import com.tesis.models.Fabricante;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class FabricanteDAOImpl extends GenericDAOImpl<Fabricante> implements FabricanteDAO {

    public Fabricante addFabricante(Fabricante fabricante) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(fabricante);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return fabricante;
    }
}
