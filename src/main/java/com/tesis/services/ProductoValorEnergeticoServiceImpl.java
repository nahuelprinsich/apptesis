package com.tesis.services;

import com.tesis.bo.ProductoValorEnergeticoBO;
import com.tesis.models.ProductoValorEnergetico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nahuel on 9/7/2018.
 */
@RestController
public class ProductoValorEnergeticoServiceImpl implements ProductoValorEnergeticoService {

    @Autowired
    private ProductoValorEnergeticoBO productoValorEnergeticoBO;

    public ProductoValorEnergeticoBO getProductoValorEnergeticoBO() {
        return productoValorEnergeticoBO;
    }

    public void setProductoValorEnergeticoBO(ProductoValorEnergeticoBO productoValorEnergeticoBO) {
        this.productoValorEnergeticoBO = productoValorEnergeticoBO;
    }

    public ProductoValorEnergetico addProductoValorEnergetico(ProductoValorEnergetico productoValorEnergetico) {
        return this.productoValorEnergeticoBO.addProductoValorEnergetico(productoValorEnergetico);
    }

    public void borrarProductoValorEnergetico(ProductoValorEnergetico productoValorEnergetico) {
        this.productoValorEnergeticoBO.borrarProductoValorEnergetico(productoValorEnergetico);
    }
}
