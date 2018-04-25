package com.tesis.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.tesis.bo.IngredienteBO;
import com.tesis.bo.ItemBO;
import com.tesis.bo.ProductoBO;
import com.tesis.models.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ProductoAction extends ActionSupport {

    @Autowired
    private ProductoBO productoBO;
    @Autowired
    private IngredienteBO ingredienteBO;
    private Ingrediente ingrediente;
    private Envase envase;
    private Extra extra;
    private ValorEnergetico valorEnergetico;
    private Producto producto;
    private Fabricante fabricante;

    public String execute(){
        return "success";
    }

    public String cargarProducto(){
        this.producto.setIngredientes(new HashSet<Ingrediente>());
        this.producto.setExtras(new HashSet<Extra>());
        this.producto.setValoresEnergeticos(new HashSet<ValorEnergetico>());
        envase.setIdEnvase(20);
        fabricante.setIdFabricante(20);
        this.producto.setEnvase(envase);
        this.producto.getExtras().add(extra);
        this.producto.setFabricante(fabricante);
        this.producto.getIngredientes().add(ingrediente);
        this.producto.getValoresEnergeticos().add(valorEnergetico);

        productoBO.add(producto);
        return "success";
    }

    public String cargarIngrediente(){
        ingredienteBO.add(ingrediente);
        return "success";
    }

    public String asociarProductoItems(){
        return "success";
    }

    public ProductoBO getProductoBO() {
        return productoBO;
    }

    public void setProductoBO(ProductoBO productoBO) {
        this.productoBO = productoBO;
    }

    public IngredienteBO getIngredienteBO() {
        return ingredienteBO;
    }

    public void setIngredienteBO(IngredienteBO ingredienteBO) {
        this.ingredienteBO = ingredienteBO;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        this.envase = envase;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public ValorEnergetico getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(ValorEnergetico valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
