package com.tesis.dao.impl;

import com.tesis.dao.ValorEnergeticoDAO;
import com.tesis.models.ValorEnergetico;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ValorEnergeticoDAOImpl extends GenericDAOImpl<ValorEnergetico> implements ValorEnergeticoDAO {

    public ValorEnergetico addValorEnergetico(ValorEnergetico valorEnergetico) {
        this.getSessionFactory().getCurrentSession().beginTransaction();
        this.getSessionFactory().getCurrentSession().save(valorEnergetico);
        this.getSessionFactory().getCurrentSession().getTransaction().commit();
        this.getSessionFactory().getCurrentSession().close();
        return valorEnergetico;
    }
}
