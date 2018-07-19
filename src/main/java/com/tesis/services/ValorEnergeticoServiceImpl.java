package com.tesis.services;

import com.tesis.bo.ValorEnergeticoBO;
import com.tesis.models.ValorEnergetico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nahuel on 6/5/2018.
 */
@RestController
public class ValorEnergeticoServiceImpl implements ValorEnergeticoService {

    @Autowired
    private ValorEnergeticoBO valorEnergeticoBO;

    public ValorEnergeticoBO getValorEnergeticoBO() {
        return valorEnergeticoBO;
    }

    public void setValorEnergeticoBO(ValorEnergeticoBO valorEnergeticoBO) {
        this.valorEnergeticoBO = valorEnergeticoBO;
    }

    public ValorEnergetico addValorEnergetico(ValorEnergetico valorEnergetico) {
        return valorEnergeticoBO.addValorEnergetico(valorEnergetico);
    }
}
