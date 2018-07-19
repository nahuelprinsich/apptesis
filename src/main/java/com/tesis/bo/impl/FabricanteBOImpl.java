package com.tesis.bo.impl;

import com.tesis.bo.FabricanteBO;
import com.tesis.dao.FabricanteDAO;
import com.tesis.models.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class FabricanteBOImpl extends GenericBOImpl<Fabricante> implements FabricanteBO {

    private FabricanteDAO fabricanteDAO;

    public FabricanteDAO getFabricanteDAO() {
        return fabricanteDAO;
    }

    public void setFabricanteDAO(FabricanteDAO fabricanteDAO) {
        this.fabricanteDAO = fabricanteDAO;
    }

    public Fabricante addFabricante(Fabricante fabricante) {
        return fabricanteDAO.addFabricante(fabricante);
    }
}
