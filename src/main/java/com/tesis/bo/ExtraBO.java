package com.tesis.bo;

import com.tesis.models.Extra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 11/3/2018.
 */
public interface ExtraBO extends GenericBO<Extra> {

    public Extra addExtra(Extra extra);

    public ArrayList getAllExtras();

    public List<Extra> getAllExtrasTabla();
}
