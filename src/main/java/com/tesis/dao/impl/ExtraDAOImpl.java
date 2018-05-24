package com.tesis.dao.impl;

import com.tesis.dao.ExtraDAO;
import com.tesis.models.Extra;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ExtraDAOImpl extends GenericDAOImpl<Extra> implements ExtraDAO {

    public Extra addExtra(Extra extra) {
        this.getSessionFactory().getCurrentSession().beginTransaction();
        this.getSessionFactory().getCurrentSession().save(extra);
        this.getSessionFactory().getCurrentSession().getTransaction().commit();
        this.getSessionFactory().getCurrentSession().close();
        return extra;
    }
}
