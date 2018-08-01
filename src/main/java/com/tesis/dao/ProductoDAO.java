package com.tesis.dao;

import com.tesis.models.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 6/12/2017.
 */
public interface ProductoDAO extends GenericDAO<Producto> {

    public Producto getProductoById(Integer id);

    public Producto getProductoByCodigo(String codigo);

    public List<Producto> getAllProductos();

    public List<Producto> getByRubro(String rubro);

    public List<Producto> getAllByIngrediente(List<String> ingredientes);

    public Producto addProducto(Producto producto);

    public ArrayList getRubros();

    public List<Producto> getProductosByRuInEx(String rubro, List<Integer> ingredientes, List<Integer> extras, String opcion);
}
