package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class Item implements Serializable {

    private long idItem;
    private String nombre;

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
