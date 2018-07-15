package com.tesis.services;

import com.tesis.bo.ProductoBO;
import com.tesis.models.Producto;
import com.tesis.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Nahuel on 9/12/2017.
 */

@RestController
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoBO productoBO;

    @RequestMapping(value = "/getProductoById", method = GET)
    public Producto getProductoById(@RequestParam(value="id") Integer id) {
        return productoBO.getProductoById(id);

    }

    @RequestMapping(value = "/getProductoByCodigo", method = GET)
    public Producto getProductoByCodigo(String codigo) {
        return productoBO.getProductoByCodigo(codigo);
    }

    @RequestMapping(value = "/getAllProductos", method = GET)
    public List<Producto> getAllProductos(){
        return productoBO.getAllProductos();
    }

    @RequestMapping(value = "/getByRubro", method = GET)
    public List<Producto> getByRubro(@RequestParam(value="rubro") String rubro) {
        return productoBO.getByRubro(rubro);
    }

    @RequestMapping(value = "/getAllByIngrediente", method = GET)
    public List<Producto> getAllByIngrediente(@RequestParam(value="ingrediente") List<String> ingredientes){
        return productoBO.getAllByIngrediente(ingredientes);
    }

    public Producto addProducto(Producto producto) {
        return productoBO.addProducto(producto);
    }

    @RequestMapping(value = "/getRubros", method = GET)
    public ArrayList getRubros() {
        return productoBO.getRubros();
    }

    @RequestMapping(value = "/getProductosByRuInEx", method = GET)
    public List<Producto> getProductosByRuInEx(@RequestParam(value="rubro")String rubro,
                                              @RequestParam(value="ingrediente") List<Integer> ingredientes,
                                              @RequestParam(value="extra") List<Integer> extras,
                                              @RequestParam(value="opcion") String opcion) {
        return productoBO.getProductosByRuInEx(rubro,ingredientes,extras,opcion);
    }

    public ProductoBO getProductoBO() {
        return productoBO;
    }

    public void setProductoBO(ProductoBO productoBO) {
        this.productoBO = productoBO;
    }
}
