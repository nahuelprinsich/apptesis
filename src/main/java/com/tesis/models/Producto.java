package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Nahuel on 6/12/2017.
 */
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producto implements Serializable {

    private Integer idProducto;
    private String codigoBarra;
    private String nombreProducto;
    private String rubro;
    private Boolean esAlimento;
    private Float porcion;
    private String tipoPorcion;
    private Envase envase;
    private Fabricante fabricante;
    @JsonManagedReference
    private Set<Comentario> comentarios;
    @JsonManagedReference
    private Set<Extra> extras;
    @JsonManagedReference
    private Set<Ingrediente> ingredientes;
    //@JsonIgnore
    //private Set<ValorEnergeticoProducto> valorEnergeticoProductos;
    //@JsonManagedReference
    //private Set<ValorEnergetico> valoresEnergeticos;
    @JsonManagedReference
    private Set<ProductoValorEnergetico> productoValorEnergetico;
    private String marca;
    private String contenidoNeto;
    private String descripcion;
    private String tipoRubro;

    public Producto(){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getContenidoNeto() {
        return contenidoNeto;
    }

    public void setContenidoNeto(String contenidoNeto) {
        this.contenidoNeto = contenidoNeto;
    }

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

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Boolean getEsAlimento() {
        return esAlimento;
    }

    public void setEsAlimento(Boolean esAlimento) {
        this.esAlimento = esAlimento;
    }

    public Float getPorcion() {
        return porcion;
    }

    public void setPorcion(Float porcion) {
        this.porcion = porcion;
    }

    public String getTipoPorcion() {
        return tipoPorcion;
    }

    public void setTipoPorcion(String tipoPorcion) {
        this.tipoPorcion = tipoPorcion;
    }

    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        this.envase = envase;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<Extra> getExtras() {
        return extras;
    }

    public void setExtras(Set<Extra> extras) {
        this.extras = extras;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Set<ProductoValorEnergetico> getProductoValorEnergetico() {
        return productoValorEnergetico;
    }

    public void setProductoValorEnergetico(Set<ProductoValorEnergetico> productoValorEnergetico) {
        this.productoValorEnergetico = productoValorEnergetico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoRubro() {
        return tipoRubro;
    }

    public void setTipoRubro(String tipoRubro) {
        this.tipoRubro = tipoRubro;
    }
}
