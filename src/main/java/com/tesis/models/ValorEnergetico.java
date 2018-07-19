package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private String tipoPorcion;
    private String linkInformacionExtra;

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

    public String getTipoPorcion() {
        return tipoPorcion;
    }

    public void setTipoPorcion(String tipoPorcion) {
        this.tipoPorcion = tipoPorcion;
    }

    public String getLinkInformacionExtra() {
        return linkInformacionExtra;
    }

    public void setLinkInformacionExtra(String linkInformacionExtra) {
        this.linkInformacionExtra = linkInformacionExtra;
    }
}
