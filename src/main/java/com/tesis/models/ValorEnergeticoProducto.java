package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ValorEnergeticoProducto implements Serializable {

    private ValorEnergeticoProductoId idValorEnergeticoProducto;
    private Float valor;
    private String tipoPorcion;

    public ValorEnergeticoProducto(){

    }

    public ValorEnergeticoProductoId getIdValorEnergeticoProducto() {
        return idValorEnergeticoProducto;
    }

    public void setIdValorEnergeticoProducto(ValorEnergeticoProductoId idValorEnergeticoProducto) {
        this.idValorEnergeticoProducto = idValorEnergeticoProducto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTipoPorcion() {
        return tipoPorcion;
    }

    public void setTipoPorcion(String tipoPorcion) {
        this.tipoPorcion = tipoPorcion;
    }
}
