package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ValorEnergetico implements Serializable {

    private Integer idValorEnergetico;
    private String nombre;
    private String descripcion;
    private Float recomendableDiario;
    //private Set<ValorEnergeticoProducto> valorEnergeticoProductos;
    @JsonBackReference
    private Set<Producto> productos;
    private Float valor;
    private String tipoPorcion;

    public ValorEnergetico(){

    }

    public Integer getIdValorEnergetico() {
        return idValorEnergetico;
    }

    public void setIdValorEnergetico(Integer idValorEnergetico) {
        this.idValorEnergetico = idValorEnergetico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getRecomendableDiario() {
        return recomendableDiario;
    }

    public void setRecomendableDiario(Float recomendableDiario) {
        this.recomendableDiario = recomendableDiario;
    }

    /*public Set<ValorEnergeticoProducto> getValorEnergeticoProductos() {
        return valorEnergeticoProductos;
    }

    public void setValorEnergeticoProductos(Set<ValorEnergeticoProducto> valorEnergeticoProductos) {
        this.valorEnergeticoProductos = valorEnergeticoProductos;
    }*/

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
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
