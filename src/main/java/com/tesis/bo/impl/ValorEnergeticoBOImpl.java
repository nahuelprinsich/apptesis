package com.tesis.bo.impl;

import com.tesis.bo.ValorEnergeticoBO;
import com.tesis.dao.ValorEnergeticoDAO;
import com.tesis.models.ValorEnergetico;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ValorEnergeticoBOImpl extends GenericBOImpl<ValorEnergetico> implements ValorEnergeticoBO {

    private ValorEnergeticoDAO valorEnergeticoDAO;

    public ValorEnergeticoDAO getValorEnergeticoDAO() {
        return valorEnergeticoDAO;
    }

    public void setValorEnergeticoDAO(ValorEnergeticoDAO valorEnergeticoDAO) {
        this.valorEnergeticoDAO = valorEnergeticoDAO;
    }

    public ValorEnergetico addValorEnergetico(ValorEnergetico valorEnergetico) {
        return valorEnergeticoDAO.addValorEnergetico(valorEnergetico);
    }
}
