package com.tesis.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.tesis.bo.IngredienteBO;
import com.tesis.bo.ItemBO;
import com.tesis.bo.ProductoBO;
import com.tesis.models.Ingrediente;
import com.tesis.models.Item;
import com.tesis.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ProductoAction extends ActionSupport {

    @Autowired
    private ProductoBO productoBO;
    @Autowired
    private IngredienteBO ingredienteBO;
    private Ingrediente ingrediente;
    private String codigo;
    private String fabricante;
    private String nombre;
    private List<Producto> listaProductos;
    private List<Item> listaItems;
    private String productoSeleccionado;
    private String itemSeleccionado;

    public String execute(){
        return "success";
    }

    public String cargarProducto(){
        Producto producto = new Producto();
        //producto.setFabricante(this.getFabricante());
        producto.setCodigoBarra(this.getCodigo());
        productoBO.add(producto);
        return "success";
    }

    public String cargarIngrediente(){
        ingredienteBO.add(ingrediente);
        return "success";
    }

    public String cargarAsociaciones(){
        listaProductos = productoBO.getAll(Producto.class);
        //listaItems = itemBO.getAll(Item.class);
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public String getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(String productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public String getItemSeleccionado() {
        return itemSeleccionado;
    }

    public void setItemSeleccionado(String itemSeleccionado) {
        this.itemSeleccionado = itemSeleccionado;
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
}
