package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class Extra implements Serializable{

    private Integer idExtra;
    private String descripcion;
    private String urlLogo;
    @JsonBackReference
    private Set<Producto> productos;
    private String tipoRubro;

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

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public String getTipoRubro() {
        return tipoRubro;
    }

    public void setTipoRubro(String tipoRubro) {
        this.tipoRubro = tipoRubro;
    }
}
