package com.tesis.services;

import com.tesis.models.Ingrediente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 10/4/2018.
 */
public interface IngredienteService {

    public List<Ingrediente> getAllIngredientes();

    public Ingrediente addIngrediente(Ingrediente ingrediente);

    public List<Ingrediente> getIngredienteByName(String nombreIngrediente);

    public ArrayList getIngredientesByTipoRubro(String tipoRubro);
}
