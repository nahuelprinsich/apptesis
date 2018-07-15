package com.tesis.dao.impl;

import com.tesis.dao.IngredienteDAO;
import com.tesis.models.Ingrediente;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class IngredienteDAOImpl extends GenericDAOImpl<Ingrediente> implements IngredienteDAO {

    public List<Ingrediente> getAllIngredientes() {
        List<Ingrediente> lista;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        lista = this.getSessionFactory().getCurrentSession().createCriteria(Ingrediente.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        this.getSessionFactory().getCurrentSession().close();
        return lista;
    }

    public Ingrediente addIngrediente(Ingrediente ingrediente) {
        this.getSessionFactory().getCurrentSession().beginTransaction();
        this.getSessionFactory().getCurrentSession().save(ingrediente);
        this.getSessionFactory().getCurrentSession().getTransaction().commit();
        this.getSessionFactory().getCurrentSession().close();
        return ingrediente;
    }

    public List<Ingrediente> getIngredienteByName(String nombreIngrediente) {
        List<Ingrediente> ingredientes;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Ingrediente.class);
        criteria.add(Restrictions.like("nombre", nombreIngrediente + '%'));
        criteria.setMaxResults(5);
        ingredientes = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        this.getSessionFactory().getCurrentSession().close();

        return ingredientes;
    }

    public List<Ingrediente> getIngredientesByTipoRubro(String tipoRubro) {
        List<Ingrediente> ingredientes;
        this.getSessionFactory().getCurrentSession().beginTransaction();
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Ingrediente.class);
        criteria.add(Restrictions.like("tipoRubro", tipoRubro + '%'));
        ingredientes = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        this.getSessionFactory().getCurrentSession().close();

        return ingredientes;
    }
}