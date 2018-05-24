package com.tesis.dao.impl;

import com.tesis.dao.EnvaseDAO;
import com.tesis.models.Envase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class EnvaseDAOImpl extends GenericDAOImpl<Envase> implements EnvaseDAO {


    public Envase addEnvase(Envase envase) {
        this.getSessionFactory().getCurrentSession().beginTransaction();
        this.getSessionFactory().getCurrentSession().saveOrUpdate(envase);
        this.getSessionFactory().getCurrentSession().getTransaction().commit();
        this.getSessionFactory().getCurrentSession().close();

        return envase;
    }
}
