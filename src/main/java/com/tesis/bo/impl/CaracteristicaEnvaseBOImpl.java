package com.tesis.bo.impl;

import com.tesis.bo.CaracteristicaEnvaseBO;
import com.tesis.dao.CaracteristicaEnvaseDAO;
import com.tesis.models.CaracteristicaEnvase;

import java.util.List;

/**
 * Created by Nahuel on 31/7/2018.
 */
public class CaracteristicaEnvaseBOImpl extends GenericBOImpl<CaracteristicaEnvase> implements CaracteristicaEnvaseBO {

    private CaracteristicaEnvaseDAO caracteristicaEnvaseDAO;

    public CaracteristicaEnvaseDAO getCaracteristicaEnvaseDAO() {
        return caracteristicaEnvaseDAO;
    }

    public void setCaracteristicaEnvaseDAO(CaracteristicaEnvaseDAO caracteristicaEnvaseDAO) {
        this.caracteristicaEnvaseDAO = caracteristicaEnvaseDAO;
    }

    public List<CaracteristicaEnvase> getAllCaracteristicas() {
        return caracteristicaEnvaseDAO.getAllCaracteristicas();
    }
}
