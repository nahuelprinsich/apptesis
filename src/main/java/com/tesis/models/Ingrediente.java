package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class Ingrediente implements Serializable {

    private Integer idIngrediente;
    private String nombre;
    private String descripcion;
    private Boolean conAdvertencia;
    @JsonBackReference
    private Set<Producto> productos;

    public Ingrediente(){

    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
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

    public Boolean getConAdvertencia() {
        return conAdvertencia;
    }

    public void setConAdvertencia(Boolean conAdvertencia) {
        this.conAdvertencia = conAdvertencia;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
