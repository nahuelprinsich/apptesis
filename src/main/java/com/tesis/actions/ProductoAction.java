package com.tesis.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.tesis.bo.ComentarioBO;
import com.tesis.bo.IngredienteBO;
import com.tesis.bo.ItemBO;
import com.tesis.bo.ProductoBO;
import com.tesis.models.*;
import com.tesis.services.*;
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
    private EnvaseService envaseService;
    @Autowired
    private ExtraService extraService;
    @Autowired
    private FabricanteService fabricanteService;
    @Autowired
    private IngredienteService ingredienteService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private ValorEnergeticoService valorEnergeticoService;
    @Autowired
    private ProductoValorEnergeticoService productoValorEnergeticoService;

    /* Colecciones */
    private String ingredientes;
    private String valoresEnergeticos;
    private String informaciones;

    /* Producto */
    private String nombreProducto;
    private String rubroProducto;
    private String codigoBarraProducto;
    private Float porcionProducto;
    private String tipoPorcionProducto;
    private String marcaProducto;
    private String contenidoNetoProducto;
    private Boolean esAlimentoProducto;
    /* Envase */
    private String tipoEnvase;
    private String descripcionEnvase;
    private Boolean ftalatosEnvase;
    private Boolean retornableEnvase;
    private Boolean reutilizableEnvase;
    private Boolean marcadoEnvase;
    private Boolean reciclableEnvase;
    private Boolean aptoConsumoEnvase;

    /* Fabricante */
    private String razonSocialFabricante;
    private String domicilioFabricante;
    private String localidadFabricante;
    private String paisFabricante;

    /* Busqueda de ingrediente */
    private String nombreIngrediente;
    private List<Ingrediente> listaBusqueda;


    public String execute(){
        return "success";
    }

    public String buscarIngrediente(){
        listaBusqueda = ingredienteService.getIngredienteByName(nombreIngrediente);
        return SUCCESS;
    }

    public String cargarProducto(){
        Ingrediente ingrediente = new Ingrediente();
        HashSet<Ingrediente> hashSetIngredientes = new HashSet<Ingrediente>();
        hashSetIngredientes.add(ingredienteService.addIngrediente(ingrediente));
        ValorEnergetico valorEnergetico = new ValorEnergetico();
        Fabricante fabricante = new Fabricante();
        Extra extra = new Extra();
        HashSet<Extra> hashSetExtra = new HashSet<Extra>();
        hashSetExtra.add(extraService.addExtra(extra));
        /*Comentario comentario = new Comentario();
        HashSet<Comentario> hashSetComentario = new HashSet<Comentario>();
        hashSetComentario.add(comentario);*/
        CaracteristicaEnvase caracteristicaEnvase = new CaracteristicaEnvase();
        caracteristicaEnvase.setIdCaracteristicaEnvase(1);
        Envase envase = new Envase();
        HashSet<CaracteristicaEnvase> hashSetCaracteristicas = new HashSet<CaracteristicaEnvase>();
        hashSetCaracteristicas.add(caracteristicaEnvase);
        envase.setCaracteristicasEnvase(hashSetCaracteristicas);
        HashSet<Envase> hashSetEnvase = new HashSet<Envase>();
        hashSetEnvase.add(envaseService.addEnvase(envase));
        caracteristicaEnvase.setEnvases(hashSetEnvase);

        Producto producto = new Producto();
        producto.setExtras(hashSetExtra);
        producto.setFabricante(fabricanteService.addFabricante(fabricante));
        producto.setEnvase(envase);
        producto.setIngredientes(hashSetIngredientes);

        ProductoValorEnergetico productoValorEnergetico = new ProductoValorEnergetico();
        productoValorEnergetico.setValorEnergetico(valorEnergeticoService.addValorEnergetico(valorEnergetico));
        productoValorEnergetico.setProducto(productoService.addProducto(producto));
        productoValorEnergetico.setValor(Float.valueOf(10));
        HashSet<ProductoValorEnergetico> hashSetProductoValor = new HashSet<ProductoValorEnergetico>();
        hashSetProductoValor.add(productoValorEnergetico);
        producto.setProductoValorEnergetico(hashSetProductoValor);
        productoValorEnergeticoService.addProductoValorEnergetico(productoValorEnergetico);
        //producto.setComentarios(hashSetComentario);


        return "success";
    }

    public Set<Ingrediente> crearListaIngredientes(){
        Set<Ingrediente> lista = new HashSet<Ingrediente>();
        String[] arregloIngredientes = this.ingredientes.split("&");
        for(String propiedad : arregloIngredientes){
            String[] stringPropiedades = propiedad.split("-");
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setNombre(stringPropiedades[0]);
            ingrediente.setDescripcion(stringPropiedades[1]);
            ingrediente.setConAdvertencia(Boolean.parseBoolean(stringPropiedades[2]));
            //
            lista.add(ingredienteService.addIngrediente(ingrediente));
        }
        return lista;
    }

    public Set<ValorEnergetico> crearListaValoresEnergeticos(){
        Set<ValorEnergetico> lista = new HashSet<ValorEnergetico>();
        String[] arregloValoresEnergeticos = this.valoresEnergeticos.split("&");
        for(String propiedad : arregloValoresEnergeticos){
            String[] stringPropiedades = propiedad.split("-");
            ValorEnergetico valorEnergetico = new ValorEnergetico();
            valorEnergetico.setNombre(stringPropiedades[0]);
            valorEnergetico.setDescripcion(stringPropiedades[1]);
            valorEnergetico.setRecomendableDiario(Float.parseFloat(stringPropiedades[2]));
            valorEnergetico.setTipoPorcion(stringPropiedades[4]);
            lista.add(valorEnergeticoService.addValorEnergetico(valorEnergetico));
        }
        return lista;
    }

    /*
    public Set<Extra> crearListaExtras(Producto producto){
        Set<Extra> lista = new HashSet<Extra>();
        String[] arreglosInformacionExtra = this.informaciones.split("&");
        for(String propiedad : arreglosInformacionExtra){
            String[] stringPropiedades = propiedad.split("-");
            Extra extra = new Extra();
            extra.setDescripcion(stringPropiedades[0]);
            extra.setProducto(producto);
            lista.add(extraService.addExtra(extra));
        }
        return lista;
    }

    public Envase crearEnvase(){
        Envase envase = new Envase();
        envase.setAptoConsumo(aptoConsumoEnvase);
        envase.setDescripcion(descripcionEnvase);
        envase.setFtalatos(ftalatosEnvase);
        envase.setMarcado(marcadoEnvase);
        envase.setReciclable(reciclableEnvase);
        envase.setRetornable(retornableEnvase);
        envase.setReutilizable(reutilizableEnvase);
        envase.setTipo(tipoEnvase);
        return envaseService.addEnvase(envase);
    }
    public Fabricante crearFabricante(){
        Fabricante fabricante = new Fabricante();
        fabricante.setRazonSocial(razonSocialFabricante);
        fabricante.setDomicilio(domicilioFabricante);
        fabricante.setLocalidad(localidadFabricante);
        fabricante.setPais(paisFabricante);
        return fabricanteService.addFabricante(fabricante);
    }*/

    public EnvaseService getEnvaseService() {
        return envaseService;
    }

    public void setEnvaseService(EnvaseService envaseService) {
        this.envaseService = envaseService;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    public FabricanteService getFabricanteService() {
        return fabricanteService;
    }

    public void setFabricanteService(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    public IngredienteService getIngredienteService() {
        return ingredienteService;
    }

    public void setIngredienteService(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public ValorEnergeticoService getValorEnergeticoService() {
        return valorEnergeticoService;
    }

    public void setValorEnergeticoService(ValorEnergeticoService valorEnergeticoService) {
        this.valorEnergeticoService = valorEnergeticoService;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getValoresEnergeticos() {
        return valoresEnergeticos;
    }

    public void setValoresEnergeticos(String valoresEnergeticos) {
        this.valoresEnergeticos = valoresEnergeticos;
    }

    public String getInformaciones() {
        return informaciones;
    }

    public void setInformaciones(String informaciones) {
        this.informaciones = informaciones;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getRubroProducto() {
        return rubroProducto;
    }

    public void setRubroProducto(String rubroProducto) {
        this.rubroProducto = rubroProducto;
    }

    public String getCodigoBarraProducto() {
        return codigoBarraProducto;
    }

    public void setCodigoBarraProducto(String codigoBarraProducto) {
        this.codigoBarraProducto = codigoBarraProducto;
    }

    public Float getPorcionProducto() {
        return porcionProducto;
    }

    public void setPorcionProducto(Float porcionProducto) {
        this.porcionProducto = porcionProducto;
    }

    public String getTipoPorcionProducto() {
        return tipoPorcionProducto;
    }

    public void setTipoPorcionProducto(String tipoPorcionProducto) {
        this.tipoPorcionProducto = tipoPorcionProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getContenidoNetoProducto() {
        return contenidoNetoProducto;
    }

    public void setContenidoNetoProducto(String contenidoNetoProducto) {
        this.contenidoNetoProducto = contenidoNetoProducto;
    }

    public Boolean getEsAlimentoProducto() {
        return esAlimentoProducto;
    }

    public void setEsAlimentoProducto(Boolean esAlimentoProducto) {
        this.esAlimentoProducto = esAlimentoProducto;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public String getDescripcionEnvase() {
        return descripcionEnvase;
    }

    public void setDescripcionEnvase(String descripcionEnvase) {
        this.descripcionEnvase = descripcionEnvase;
    }

    public Boolean getFtalatosEnvase() {
        return ftalatosEnvase;
    }

    public void setFtalatosEnvase(Boolean ftalatosEnvase) {
        this.ftalatosEnvase = ftalatosEnvase;
    }

    public Boolean getRetornableEnvase() {
        return retornableEnvase;
    }

    public void setRetornableEnvase(Boolean retornableEnvase) {
        this.retornableEnvase = retornableEnvase;
    }

    public Boolean getReutilizableEnvase() {
        return reutilizableEnvase;
    }

    public void setReutilizableEnvase(Boolean reutilizableEnvase) {
        this.reutilizableEnvase = reutilizableEnvase;
    }

    public Boolean getMarcadoEnvase() {
        return marcadoEnvase;
    }

    public void setMarcadoEnvase(Boolean marcadoEnvase) {
        this.marcadoEnvase = marcadoEnvase;
    }

    public Boolean getReciclableEnvase() {
        return reciclableEnvase;
    }

    public void setReciclableEnvase(Boolean reciclableEnvase) {
        this.reciclableEnvase = reciclableEnvase;
    }

    public Boolean getAptoConsumoEnvase() {
        return aptoConsumoEnvase;
    }

    public void setAptoConsumoEnvase(Boolean aptoConsumoEnvase) {
        this.aptoConsumoEnvase = aptoConsumoEnvase;
    }

    public String getRazonSocialFabricante() {
        return razonSocialFabricante;
    }

    public void setRazonSocialFabricante(String razonSocialFabricante) {
        this.razonSocialFabricante = razonSocialFabricante;
    }

    public String getDomicilioFabricante() {
        return domicilioFabricante;
    }

    public void setDomicilioFabricante(String domicilioFabricante) {
        this.domicilioFabricante = domicilioFabricante;
    }

    public String getLocalidadFabricante() {
        return localidadFabricante;
    }

    public void setLocalidadFabricante(String localidadFabricante) {
        this.localidadFabricante = localidadFabricante;
    }

    public String getPaisFabricante() {
        return paisFabricante;
    }

    public void setPaisFabricante(String paisFabricante) {
        this.paisFabricante = paisFabricante;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }
}
