package com.tesis.dao.impl;

import com.tesis.dao.FabricanteDAO;
import com.tesis.models.Fabricante;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class FabricanteDAOImpl extends GenericDAOImpl<Fabricante> implements FabricanteDAO {

    public Fabricante addFabricante(Fabricante fabricante) {
        this.getSessionFactory().getCurrentSession().beginTransaction();
        this.getSessionFactory().getCurrentSession().save(fabricante);
        this.getSessionFactory().getCurrentSession().getTransaction().commit();
        this.getSessionFactory().getCurrentSession().close();
        return fabricante;
    }
}
