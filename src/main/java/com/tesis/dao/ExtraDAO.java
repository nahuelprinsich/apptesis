package com.tesis.dao;

import com.tesis.models.Extra;

/**
 * Created by Nahuel on 11/3/2018.
 */
public interface ExtraDAO extends GenericDAO<Extra> {

    public Extra addExtra(Extra extra);
}
