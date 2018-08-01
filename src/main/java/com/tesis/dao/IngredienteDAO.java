package com.tesis.dao;

import com.tesis.models.Ingrediente;

import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public interface IngredienteDAO extends GenericDAO<Ingrediente> {

    List<Ingrediente> getAllIngredientes();

    public Ingrediente addIngrediente(Ingrediente ingrediente);

    public List<Ingrediente> getIngredienteByName(String nombreIngrediente);

    public List<Ingrediente> getIngredientesByTipoRubro(String tipoRubro);
}
