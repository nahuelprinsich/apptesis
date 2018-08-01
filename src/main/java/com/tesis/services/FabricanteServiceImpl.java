package com.tesis.services;

import com.tesis.bo.FabricanteBO;
import com.tesis.models.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nahuel on 6/5/2018.
 */
@RestController
public class FabricanteServiceImpl implements FabricanteService {

    @Autowired
    private FabricanteBO fabricanteBO;

    public FabricanteBO getFabricanteBO() {
        return fabricanteBO;
    }

    public void setFabricanteBO(FabricanteBO fabricanteBO) {
        this.fabricanteBO = fabricanteBO;
    }

    public Fabricante addFabricante(Fabricante fabricante) {
        return fabricanteBO.addFabricante(fabricante);
    }
}
