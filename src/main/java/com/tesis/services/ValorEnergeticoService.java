package com.tesis.services;

import com.tesis.models.ValorEnergetico;

import java.util.List;

/**
 * Created by Nahuel on 6/5/2018.
 */
public interface ValorEnergeticoService {

    public ValorEnergetico addValorEnergetico(ValorEnergetico valorEnergetico);

    public List<ValorEnergetico> getAllValoresEnergeticos();
}
