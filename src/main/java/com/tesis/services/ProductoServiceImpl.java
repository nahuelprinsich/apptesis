package com.tesis.services;

import com.tesis.bo.ProductoBO;
import com.tesis.models.Producto;
import com.tesis.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    public ProductoBO getProductoBO() {
        return productoBO;
    }

    public void setProductoBO(ProductoBO productoBO) {
        this.productoBO = productoBO;
    }
}
