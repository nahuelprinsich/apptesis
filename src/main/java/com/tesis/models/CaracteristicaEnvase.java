package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Nahuel on 2/7/2018.
 */
public class CaracteristicaEnvase implements Serializable {

    private Integer idCaracteristicaEnvase;
    private String categoria;
    private String descripcion;
    private Integer valor;
    @JsonBackReference
    private Set<Envase> envases;

    public Integer getIdCaracteristicaEnvase() {
        return idCaracteristicaEnvase;
    }

    public void setIdCaracteristicaEnvase(Integer idCaracteristicaEnvase) {
        this.idCaracteristicaEnvase = idCaracteristicaEnvase;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Set<Envase> getEnvases() {
        return envases;
    }

    public void setEnvases(Set<Envase> envases) {
        this.envases = envases;
    }
}
