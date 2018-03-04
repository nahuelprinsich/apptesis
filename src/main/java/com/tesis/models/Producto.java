package com.tesis.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class Producto implements Serializable {

    private Integer idProducto;
    private String codigoBarra;
    private String fabricante;
    private Set<Item> items;
    private Set<Comentario> comentarios;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Set<Item> getItems() { return items; }

    public void setItems(Set<Item> items) { this.items = items; }

    public Set<Comentario> getComentarios() { return comentarios; }

    public void setComentarios(Set<Comentario> comentarios) { this.comentarios = comentarios; }
}
