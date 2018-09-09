package com.tesis.services;

import com.tesis.models.Extra;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nahuel on 6/5/2018.
 */
public interface ExtraService {

    public Extra addExtra(Extra extra);

    public ArrayList getAllExtras();
}
