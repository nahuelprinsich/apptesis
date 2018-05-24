package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class Envase implements Serializable {

    private Integer idEnvase;
    private String tipo;
    private String descripcion;
    private Boolean ftalatos;
    private Boolean retornable;
    private Boolean reutilizable;
    private Boolean marcado;
    private Boolean reciclable;
    private Boolean aptoConsumo;

    public Envase(){

    }

    public Integer getIdEnvase() {
        return idEnvase;
    }

    public void setIdEnvase(Integer idEnvase) {
        this.idEnvase = idEnvase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getFtalatos() {
        return ftalatos;
    }

    public void setFtalatos(Boolean ftalatos) {
        this.ftalatos = ftalatos;
    }

    public Boolean getRetornable() {
        return retornable;
    }

    public void setRetornable(Boolean retornable) {
        this.retornable = retornable;
    }

    public Boolean getReutilizable() {
        return reutilizable;
    }

    public void setReutilizable(Boolean reutilizable) {
        this.reutilizable = reutilizable;
    }

    public Boolean getMarcado() {
        return marcado;
    }

    public void setMarcado(Boolean marcado) {
        this.marcado = marcado;
    }

    public Boolean getReciclable() {
        return reciclable;
    }

    public void setReciclable(Boolean reciclable) {
        this.reciclable = reciclable;
    }

    public Boolean getAptoConsumo() {
        return aptoConsumo;
    }

    public void setAptoConsumo(Boolean aptoConsumo) {
        this.aptoConsumo = aptoConsumo;
    }

}
