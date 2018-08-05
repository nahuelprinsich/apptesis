package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 4/8/2018.
 */
public class Usuario implements Serializable{

    private Integer idUsuario;
    private String nombre;
    private String apellido;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
