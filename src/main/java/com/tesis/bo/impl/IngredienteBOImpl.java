package com.tesis.bo.impl;

import com.tesis.bo.IngredienteBO;
import com.tesis.dao.IngredienteDAO;
import com.tesis.models.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteDAO.getAllIngredientes();
    }

    public Ingrediente addIngrediente(Ingrediente ingrediente) {
        return ingredienteDAO.addIngrediente(ingrediente);
    }

    public List<Ingrediente> getIngredienteByName(String nombreIngrediente) {
        return ingredienteDAO.getIngredienteByName(nombreIngrediente);
    }

    public ArrayList getIngredientesByTipoRubro(String tipoRubro) {
        return ingredienteDAO.getIngredientesByTipoRubro(tipoRubro);
    }
}
