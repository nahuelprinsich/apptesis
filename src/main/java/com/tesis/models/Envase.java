package com.tesis.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class Envase implements Serializable {

    private Integer idEnvase;
    private String descripcion;
    private String urlImagen;
    @JsonManagedReference
    private Set<CaracteristicaEnvase> caracteristicasEnvase;

    public Envase(){

    }

    public Integer getIdEnvase() {
        return idEnvase;
    }

    public void setIdEnvase(Integer idEnvase) {
        this.idEnvase = idEnvase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Set<CaracteristicaEnvase> getCaracteristicasEnvase() {
        return caracteristicasEnvase;
    }

    public void setCaracteristicasEnvase(Set<CaracteristicaEnvase> caracteristicasEnvase) {
        this.caracteristicasEnvase = caracteristicasEnvase;
    }
}
