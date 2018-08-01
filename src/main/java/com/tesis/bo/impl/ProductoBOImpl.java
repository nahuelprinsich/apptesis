package com.tesis.bo.impl;

import com.tesis.bo.ProductoBO;
import com.tesis.dao.ProductoDAO;
import com.tesis.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ProductoBOImpl extends GenericBOImpl<Producto> implements ProductoBO {

    private ProductoDAO productoDAO;

    public ProductoDAO getProductoDAO() { return productoDAO; }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public Producto getProductoById(Integer id) {
        return productoDAO.getProductoById(id);
    }

    public Producto getProductoByCodigo(String codigo) {
        return productoDAO.getProductoByCodigo(codigo);
    }

    public List<Producto> getAllProductos() {
        return productoDAO.getAllProductos();
    }

    public List<Producto> getByRubro(String rubro){
        return productoDAO.getByRubro(rubro);
    }

    public List<Producto> getAllByIngrediente(List<String> ingredientes) {
        return productoDAO.getAllByIngrediente(ingredientes);
    }

    public Producto addProducto(Producto producto){
        return productoDAO.addProducto(producto);
    }

    public ArrayList getRubros() {
        return productoDAO.getRubros();
    }

    public List<Producto> getProductosByRuInEx(String rubro, List<Integer> ingredientes, List<Integer> extras, String opcion) {
        return productoDAO.getProductosByRuInEx(rubro,ingredientes,extras,opcion);
    }
}
