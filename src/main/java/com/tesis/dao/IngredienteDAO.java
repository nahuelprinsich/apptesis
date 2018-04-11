package com.tesis.dao;

import com.tesis.models.Ingrediente;

import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public interface IngredienteDAO extends GenericDAO<Ingrediente> {

    List<Ingrediente> getAllIngredientes();
}
