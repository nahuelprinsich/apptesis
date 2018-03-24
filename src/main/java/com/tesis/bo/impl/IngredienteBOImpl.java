package com.tesis.bo.impl;

import com.tesis.bo.IngredienteBO;
import com.tesis.dao.IngredienteDAO;
import com.tesis.models.Ingrediente;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class IngredienteBOImpl extends GenericBOImpl<Ingrediente> implements IngredienteBO {

    private IngredienteDAO ingredienteDAO;

    public IngredienteDAO getIngredienteDAO() {
        return ingredienteDAO;
    }

    public void setIngredienteDAO(IngredienteDAO ingredienteDAO) {
        this.ingredienteDAO = ingredienteDAO;
    }
}
