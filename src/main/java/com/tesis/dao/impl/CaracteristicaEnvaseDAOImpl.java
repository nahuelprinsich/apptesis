package com.tesis.dao.impl;

import com.tesis.dao.CaracteristicaEnvaseDAO;
import com.tesis.models.CaracteristicaEnvase;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Nahuel on 31/7/2018.
 */
public class CaracteristicaEnvaseDAOImpl extends GenericDAOImpl<CaracteristicaEnvase> implements CaracteristicaEnvaseDAO {

    public List<CaracteristicaEnvase> getAllCaracteristicas() {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        List<CaracteristicaEnvase> lista;
        try {
            tx = session.beginTransaction();
            lista = session.createCriteria(CaracteristicaEnvase.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
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
