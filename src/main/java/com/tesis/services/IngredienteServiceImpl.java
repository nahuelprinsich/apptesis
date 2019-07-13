package com.tesis.services;

import com.tesis.bo.IngredienteBO;
import com.tesis.models.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Nahuel on 10/4/2018.
 */
@RestController
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    IngredienteBO ingredienteBO;

    @RequestMapping(value = "/getAllIngredientes", method = GET)
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteBO.getAllIngredientes();
    }

    public Ingrediente addIngrediente(Ingrediente ingrediente) {
        return ingredienteBO.addIngrediente(ingrediente);
    }

    public List<Ingrediente> getIngredienteByName(String nombreIngrediente) {
        return ingredienteBO.getIngredienteByName(nombreIngrediente);
    }

    @RequestMapping(value = "/getIngredientesByTipoRubro", method = GET)
    public ArrayList getIngredientesByTipoRubro(@RequestParam(value="tipoRubro") String tipoRubro) {
        return ingredienteBO.getIngredientesByTipoRubro(tipoRubro);
    }

    public IngredienteBO getIngredienteBO() {
        return ingredienteBO;
    }

    public void setIngredienteBO(IngredienteBO ingredienteBO) {
        this.ingredienteBO = ingredienteBO;
    }
}
