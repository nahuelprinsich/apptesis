package com.tesis.bo.impl;

import com.tesis.bo.ExtraBO;
import com.tesis.dao.ExtraDAO;
import com.tesis.models.Extra;

/**
 * Created by Nahuel on 11/3/2018.
 */
public class ExtraBOImpl extends GenericBOImpl<Extra> implements ExtraBO {

    private ExtraDAO extraDAO;

    public ExtraDAO getExtraDAO() {
        return extraDAO;
    }

    public void setExtraDAO(ExtraDAO extraDAO) {
        this.extraDAO = extraDAO;
    }
}