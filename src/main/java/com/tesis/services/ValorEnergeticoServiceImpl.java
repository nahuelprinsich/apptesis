package com.tesis.services;

import com.tesis.bo.ValorEnergeticoBO;
import com.tesis.models.ValorEnergetico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(value = "/getAllValoresEnergeticos", method = GET)
    public List<ValorEnergetico> getAllValoresEnergeticos() {
        return valorEnergeticoBO.getAllValoresEnergeticos();
    }
}
