package com.tesis.services;

import com.tesis.bo.EnvaseBO;
import com.tesis.models.Envase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nahuel on 6/5/2018.
 */
@RestController
public class EnvaseServiceImpl implements EnvaseService {

    @Autowired
    private EnvaseBO envaseBO;

    public EnvaseBO getEnvaseBO() {
        return envaseBO;
    }

    public void setEnvaseBO(EnvaseBO envaseBO) {
        this.envaseBO = envaseBO;
    }

    public Envase addEnvase(Envase envase) {
        return envaseBO.addEnvase(envase);
    }
}
