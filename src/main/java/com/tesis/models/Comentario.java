package com.tesis.models;

import java.io.Serializable;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class Comentario implements Serializable {

    private long idComentario;
    private String descripcion;

    public long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(long idComentario) {
        this.idComentario = idComentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
