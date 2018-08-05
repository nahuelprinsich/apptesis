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
    @Autowired
    private CaracteristicaEnvaseService caracteristicaEnvaseService;
    @Autowired
    private UsuarioService usuarioService;

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
    private String descripcionProducto;
    private String tipoRubroProducto;
    private String urlImagenProducto;
    /* Envase */
    private String descripcionEnvase;
    private String caracteristicaRetornable;
    private String caracteristicaReutilizable;
    private String caracteristicaReciclable;
    private String caracteristicaCompostable;
    private String caracteristicaMP;
    private String caracteristicaCO;

    /* Fabricante */
    private String razonSocialFabricante;

    private String nombreIngrediente;
    private String descripcionIngrediente;
    private String linkIngrediente;
    private String tipoRubroIngrediente;
    private String conAdvertenciaIngrediente;

    private String nombreValorEnergetico;
    private String descripcionValorEnergetico;
    private String recomendableValorEnergetico;
    private String tipoPorcionValorEnergetico;
    private String linkValorEnergetico;

    private String descripcionExtra;
    private String urlLogo;
    private String tipoRubroExtra;

    private String nombreUsuario;
    private String apellidoUsuario;

    public String execute(){
        return "success";
    }

    public String cargarIngrediente(){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre(nombreIngrediente);
        ingrediente.setDescripcion(descripcionIngrediente);
        ingrediente.setLinkInformacionExtra(linkIngrediente);
        ingrediente.setTipoRubro(tipoRubroIngrediente);
        ingrediente.setConAdvertencia(Boolean.valueOf(conAdvertenciaIngrediente));
        ingredienteService.addIngrediente(ingrediente);
        return "success";
    }

    public String cargarValorEnergetico(){
        ValorEnergetico valorEnergetico = new ValorEnergetico();
        valorEnergetico.setNombre(nombreValorEnergetico);
        valorEnergetico.setDescripcion(descripcionValorEnergetico);
        if(!("").equals(recomendableValorEnergetico)){
            valorEnergetico.setRecomendableDiario(Float.valueOf(recomendableValorEnergetico));
        } else {
            valorEnergetico.setRecomendableDiario(Float.valueOf(0));
        }
        valorEnergetico.setTipoPorcion(tipoPorcionValorEnergetico);
        valorEnergetico.setLinkInformacionExtra(linkValorEnergetico);
        valorEnergeticoService.addValorEnergetico(valorEnergetico);
        return "success";
    }

    public String cargarExtra(){
        Extra extra = new Extra();
        extra.setDescripcion(descripcionExtra);
        extra.setUrlLogo(urlLogo);
        extra.setTipoRubro(tipoRubroExtra);
        extraService.addExtra(extra);
        return "success";
    }

    public String cargarProducto(){
        Fabricante fabricante = new Fabricante();
        fabricante.setNombre(razonSocialFabricante);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombreUsuario);
        usuario.setApellido(apellidoUsuario);

        List<CaracteristicaEnvase> listaCaracteristicas = caracteristicaEnvaseService.getAllCaracteristicas();
        HashSet<CaracteristicaEnvase> hashSetCaracteristicas = new HashSet<CaracteristicaEnvase>();
        CaracteristicaEnvase caracteristicaEnvase = new CaracteristicaEnvase();
        caracteristicaEnvase.setIdCaracteristicaEnvase(Integer.valueOf(caracteristicaRetornable));
        hashSetCaracteristicas.add(caracteristicaEnvase);

        CaracteristicaEnvase caracteristicaEnvase1 = new CaracteristicaEnvase();
        caracteristicaEnvase1.setIdCaracteristicaEnvase(Integer.valueOf(caracteristicaReutilizable));
        hashSetCaracteristicas.add(caracteristicaEnvase1);

        CaracteristicaEnvase caracteristicaEnvase2 = new CaracteristicaEnvase();
        caracteristicaEnvase2.setIdCaracteristicaEnvase(Integer.valueOf(caracteristicaReciclable));
        hashSetCaracteristicas.add(caracteristicaEnvase2);

        CaracteristicaEnvase caracteristicaEnvase3 = new CaracteristicaEnvase();
        caracteristicaEnvase3.setIdCaracteristicaEnvase(Integer.valueOf(caracteristicaCompostable));
        hashSetCaracteristicas.add(caracteristicaEnvase3);

        CaracteristicaEnvase caracteristicaEnvase4 = new CaracteristicaEnvase();
        caracteristicaEnvase4.setIdCaracteristicaEnvase(Integer.valueOf(caracteristicaMP));
        hashSetCaracteristicas.add(caracteristicaEnvase4);

        CaracteristicaEnvase caracteristicaEnvase5 = new CaracteristicaEnvase();
        caracteristicaEnvase5.setIdCaracteristicaEnvase(Integer.valueOf(caracteristicaCO));
        hashSetCaracteristicas.add(caracteristicaEnvase5);

        Envase envase = new Envase();
        envase.setDescripcion(descripcionEnvase);
        envase.setCaracteristicasEnvase(hashSetCaracteristicas);
        HashSet<Envase> hashSetEnvase = new HashSet<Envase>();
        hashSetEnvase.add(envaseService.addEnvase(envase));

        Producto producto = new Producto();
        producto.setNombreProducto(nombreProducto);
        producto.setCodigoBarra(codigoBarraProducto);
        producto.setRubro(rubroProducto);
        producto.setPorcion(porcionProducto);
        producto.setTipoPorcion(tipoPorcionProducto);
        producto.setMarca(marcaProducto);
        producto.setContenidoNeto(contenidoNetoProducto);
        producto.setEsAlimento(esAlimentoProducto);
        producto.setDescripcion(descripcionProducto);
        producto.setTipoRubro(tipoRubroProducto);
        producto.setUrlImagen(urlImagenProducto);

        producto.setUsuario(usuarioService.addUsuario(usuario));
        producto.setExtras(crearListaExtras());
        producto.setFabricante(fabricanteService.addFabricante(fabricante));
        producto.setEnvase(envase);
        producto.setIngredientes(crearListaIngredientes());

        productoService.addProducto(producto);
        crearListaValoresEnergeticos(producto);


        return "success";
    }

    public Set<Ingrediente> crearListaIngredientes(){
        Set<Ingrediente> lista = new HashSet<Ingrediente>();
        if(!("").equals(ingredientes)){
            String[] arregloIngredientes = this.ingredientes.split("&");
            for(String propiedad : arregloIngredientes){
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(Integer.valueOf(propiedad));
                lista.add(ingrediente);
            }
        }
        return lista;
    }

    public Set<ProductoValorEnergetico> crearListaValoresEnergeticos(Producto producto){
        Set<ProductoValorEnergetico> lista = new HashSet<ProductoValorEnergetico>();
        if(!("").equals(valoresEnergeticos)){
            String[] arregloValoresEnergeticos = this.valoresEnergeticos.split("&");
            for(String propiedad : arregloValoresEnergeticos){
                String[] stringPropiedades = propiedad.split("-");
                ValorEnergetico valorEnergetico = new ValorEnergetico();
                valorEnergetico.setIdValorEnergetico(Integer.valueOf(stringPropiedades[0]));

                ProductoValorEnergetico productoValorEnergetico = new ProductoValorEnergetico();
                productoValorEnergetico.setValorEnergetico(valorEnergetico);
                productoValorEnergetico.setValor(Float.valueOf(stringPropiedades[1]));
                productoValorEnergetico.setProducto(producto);

                lista.add(productoValorEnergeticoService.addProductoValorEnergetico(productoValorEnergetico));
            }
        }
        return lista;
    }

    public Set<Extra> crearListaExtras(){
        Set<Extra> lista = new HashSet<Extra>();
        if(!("").equals(informaciones)){
            String[] arreglosInformacionExtra = this.informaciones.split("&");
            for(String propiedad : arreglosInformacionExtra){
                Extra extra = new Extra();
                extra.setIdExtra(Integer.valueOf(propiedad));
                lista.add(extra);
            }
        }
        return lista;
    }

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

    public String getDescripcionEnvase() {
        return descripcionEnvase;
    }

    public void setDescripcionEnvase(String descripcionEnvase) {
        this.descripcionEnvase = descripcionEnvase;
    }

    public String getRazonSocialFabricante() {
        return razonSocialFabricante;
    }

    public void setRazonSocialFabricante(String razonSocialFabricante) {
        this.razonSocialFabricante = razonSocialFabricante;
    }

    public ProductoValorEnergeticoService getProductoValorEnergeticoService() {
        return productoValorEnergeticoService;
    }

    public void setProductoValorEnergeticoService(ProductoValorEnergeticoService productoValorEnergeticoService) {
        this.productoValorEnergeticoService = productoValorEnergeticoService;
    }

    public String getCaracteristicaRetornable() {
        return caracteristicaRetornable;
    }

    public void setCaracteristicaRetornable(String caracteristicaRetornable) {
        this.caracteristicaRetornable = caracteristicaRetornable;
    }

    public String getCaracteristicaReutilizable() {
        return caracteristicaReutilizable;
    }

    public void setCaracteristicaReutilizable(String caracteristicaReutilizable) {
        this.caracteristicaReutilizable = caracteristicaReutilizable;
    }

    public String getCaracteristicaReciclable() {
        return caracteristicaReciclable;
    }

    public void setCaracteristicaReciclable(String caracteristicaReciclable) {
        this.caracteristicaReciclable = caracteristicaReciclable;
    }

    public String getCaracteristicaCompostable() {
        return caracteristicaCompostable;
    }

    public void setCaracteristicaCompostable(String caracteristicaCompostable) {
        this.caracteristicaCompostable = caracteristicaCompostable;
    }

    public String getCaracteristicaMP() {
        return caracteristicaMP;
    }

    public void setCaracteristicaMP(String caracteristicaMP) {
        this.caracteristicaMP = caracteristicaMP;
    }

    public String getCaracteristicaCO() {
        return caracteristicaCO;
    }

    public void setCaracteristicaCO(String caracteristicaCO) {
        this.caracteristicaCO = caracteristicaCO;
    }

    public CaracteristicaEnvaseService getCaracteristicaEnvaseService() {
        return caracteristicaEnvaseService;
    }

    public void setCaracteristicaEnvaseService(CaracteristicaEnvaseService caracteristicaEnvaseService) {
        this.caracteristicaEnvaseService = caracteristicaEnvaseService;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getTipoRubroProducto() {
        return tipoRubroProducto;
    }

    public void setTipoRubroProducto(String tipoRubroProducto) {
        this.tipoRubroProducto = tipoRubroProducto;
    }

    public String getUrlImagenProducto() {
        return urlImagenProducto;
    }

    public void setUrlImagenProducto(String urlImagenProducto) {
        this.urlImagenProducto = urlImagenProducto;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public String getDescripcionIngrediente() {
        return descripcionIngrediente;
    }

    public void setDescripcionIngrediente(String descripcionIngrediente) {
        this.descripcionIngrediente = descripcionIngrediente;
    }

    public String getLinkIngrediente() {
        return linkIngrediente;
    }

    public void setLinkIngrediente(String linkIngrediente) {
        this.linkIngrediente = linkIngrediente;
    }

    public String getTipoRubroIngrediente() {
        return tipoRubroIngrediente;
    }

    public void setTipoRubroIngrediente(String tipoRubroIngrediente) {
        this.tipoRubroIngrediente = tipoRubroIngrediente;
    }

    public String getConAdvertenciaIngrediente() {
        return conAdvertenciaIngrediente;
    }

    public void setConAdvertenciaIngrediente(String conAdvertenciaIngrediente) {
        this.conAdvertenciaIngrediente = conAdvertenciaIngrediente;
    }

    public String getNombreValorEnergetico() {
        return nombreValorEnergetico;
    }

    public void setNombreValorEnergetico(String nombreValorEnergetico) {
        this.nombreValorEnergetico = nombreValorEnergetico;
    }

    public String getDescripcionValorEnergetico() {
        return descripcionValorEnergetico;
    }

    public void setDescripcionValorEnergetico(String descripcionValorEnergetico) {
        this.descripcionValorEnergetico = descripcionValorEnergetico;
    }

    public String getRecomendableValorEnergetico() {
        return recomendableValorEnergetico;
    }

    public void setRecomendableValorEnergetico(String recomendableValorEnergetico) {
        this.recomendableValorEnergetico = recomendableValorEnergetico;
    }

    public String getTipoPorcionValorEnergetico() {
        return tipoPorcionValorEnergetico;
    }

    public void setTipoPorcionValorEnergetico(String tipoPorcionValorEnergetico) {
        this.tipoPorcionValorEnergetico = tipoPorcionValorEnergetico;
    }

    public String getLinkValorEnergetico() {
        return linkValorEnergetico;
    }

    public void setLinkValorEnergetico(String linkValorEnergetico) {
        this.linkValorEnergetico = linkValorEnergetico;
    }

    public String getDescripcionExtra() {
        return descripcionExtra;
    }

    public void setDescripcionExtra(String descripcionExtra) {
        this.descripcionExtra = descripcionExtra;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getTipoRubroExtra() {
        return tipoRubroExtra;
    }

    public void setTipoRubroExtra(String tipoRubroExtra) {
        this.tipoRubroExtra = tipoRubroExtra;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}
