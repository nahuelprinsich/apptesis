package com.tesis.dao;

import com.tesis.models.Extra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public interface ExtraDAO extends GenericDAO<Extra> {

    public Extra addExtra(Extra extra);

    public ArrayList getAllExtras();
}
