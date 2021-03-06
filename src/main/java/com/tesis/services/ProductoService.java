package com.tesis.services;

import com.tesis.models.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 14/1/2018.
 */
public interface ProductoService {

    public Producto getProductoById(Integer id);

    public Producto getProductoByCodigo(String codigo);

    public List<Producto> getAllProductos();

    public List<Producto> getByRubro(String rubro);

    public List<Producto> getAllByIngrediente(List<String> ingredientes);

    public Producto addProducto(Producto producto);

    public ArrayList getRubros();

    public ArrayList getProductosByRuInEx(String rubro, List<Integer> ingredientes, List<Integer> extras, String opcion);

    public void eliminarProducto(Integer idProducto);
}
