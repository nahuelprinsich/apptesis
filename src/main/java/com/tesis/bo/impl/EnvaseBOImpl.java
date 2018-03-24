package com.tesis.bo.impl;

import com.tesis.bo.EnvaseBO;
import com.tesis.dao.EnvaseDAO;
import com.tesis.models.Envase;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class EnvaseBOImpl extends GenericBOImpl<Envase> implements EnvaseBO {

    private EnvaseDAO envaseDAO;

    public EnvaseDAO getEnvaseDAO() {
        return envaseDAO;
    }

    public void setEnvaseDAO(EnvaseDAO envaseDAO) {
        this.envaseDAO = envaseDAO;
    }
}
