package com.tesis.bo;

import com.tesis.models.Ingrediente;

import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public interface IngredienteBO extends GenericBO<Ingrediente> {

    public List<Ingrediente> getAllIngredientes();
}
