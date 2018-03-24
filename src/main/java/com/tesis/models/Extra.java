package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class Extra implements Serializable{

    private Integer idExtra;
    private String descripcion;

    public Extra(){

    }

    public Integer getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(Integer idExtra) {
        this.idExtra = idExtra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
