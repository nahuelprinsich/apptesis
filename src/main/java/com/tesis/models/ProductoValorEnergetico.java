package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

/**
 * Created by Nahuel on 23/6/2018.
 */
public class ProductoValorEnergetico implements Serializable {

    private Integer idProductoValorEnergetico;
    private Float valor;
    private ValorEnergetico valorEnergetico;
    @JsonBackReference
    private Producto producto;

    public Integer getIdProductoValorEnergetico() {
        return idProductoValorEnergetico;
    }

    public void setIdProductoValorEnergetico(Integer idProductoValorEnergetico) {
        this.idProductoValorEnergetico = idProductoValorEnergetico;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public ValorEnergetico getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(ValorEnergetico valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
