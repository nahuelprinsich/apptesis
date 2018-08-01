package com.tesis.services;

import com.tesis.bo.CaracteristicaEnvaseBO;
import com.tesis.models.CaracteristicaEnvase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Nahuel on 31/7/2018.
 */

@RestController
public class CaracteristicaEnvaseServiceImpl implements CaracteristicaEnvaseService {

    @Autowired
    private CaracteristicaEnvaseBO caracteristicaEnvaseBO;

    public CaracteristicaEnvaseBO getCaracteristicaEnvaseBO() {
        return caracteristicaEnvaseBO;
    }

    public void setCaracteristicaEnvaseBO(CaracteristicaEnvaseBO caracteristicaEnvaseBO) {
        this.caracteristicaEnvaseBO = caracteristicaEnvaseBO;
    }

    public List<CaracteristicaEnvase> getAllCaracteristicas() {
        return caracteristicaEnvaseBO.getAllCaracteristicas();
    }
}
