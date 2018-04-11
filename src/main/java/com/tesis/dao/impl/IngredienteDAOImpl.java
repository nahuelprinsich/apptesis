package com.tesis.dao.impl;

import com.tesis.dao.IngredienteDAO;
import com.tesis.models.Ingrediente;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class IngredienteDAOImpl extends GenericDAOImpl<Ingrediente> implements IngredienteDAO {

    public List<Ingrediente> getAllIngredientes() {
        List<Ingrediente> lista;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        lista = this.getSessionFactory().getCurrentSession().createCriteria(Ingrediente.class).list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }
}
