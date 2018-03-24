package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 20/3/2018.
 */
public class ValorEnergeticoProductoId implements Serializable {

    private Producto producto;
    private ValorEnergetico valorEnergetico;

    public ValorEnergeticoProductoId(){
        super();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ValorEnergetico getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(ValorEnergetico valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }
}
