package com.tesis.dao;

import com.tesis.models.ValorEnergetico;

import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public interface ValorEnergeticoDAO extends GenericDAO<ValorEnergetico> {

    public ValorEnergetico addValorEnergetico(ValorEnergetico valorEnergetico);

    public List<ValorEnergetico> getAllValoresEnergeticos();
}
