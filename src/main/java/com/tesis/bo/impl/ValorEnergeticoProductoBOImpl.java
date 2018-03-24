package com.tesis.bo.impl;

import com.tesis.bo.ValorEnergeticoProductoBO;
import com.tesis.dao.ValorEnergeticoProductoDAO;
import com.tesis.models.ValorEnergeticoProducto;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ValorEnergeticoProductoBOImpl extends GenericBOImpl<ValorEnergeticoProducto> implements ValorEnergeticoProductoBO {

    private ValorEnergeticoProductoDAO valorEnergeticoProductoDAO;

    public ValorEnergeticoProductoDAO getValorEnergeticoProductoDAO() {
        return valorEnergeticoProductoDAO;
    }

    public void setValorEnergeticoProductoDAO(ValorEnergeticoProductoDAO valorEnergeticoProductoDAO) {
        this.valorEnergeticoProductoDAO = valorEnergeticoProductoDAO;
    }
}
