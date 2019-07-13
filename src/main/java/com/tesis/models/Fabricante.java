package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class Fabricante implements Serializable {

    private Integer idFabricante;
    private String nombre;

    public Fabricante(){

    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
