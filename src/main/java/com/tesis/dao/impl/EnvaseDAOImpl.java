package com.tesis.dao.impl;

import com.tesis.dao.EnvaseDAO;
import com.tesis.models.Envase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class EnvaseDAOImpl extends GenericDAOImpl<Envase> implements EnvaseDAO {


    public Envase addEnvase(Envase envase) {

        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(envase);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return envase;
    }
}
