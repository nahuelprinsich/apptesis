package com.tesis.services;

import com.tesis.bo.ExtraBO;
import com.tesis.models.Extra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nahuel on 6/5/2018.
 */
@RestController
public class ExtraServiceImpl implements ExtraService {

    @Autowired
    private ExtraBO extraBO;

    public ExtraBO getExtraBO() {
        return extraBO;
    }

    public void setExtraBO(ExtraBO extraBO) {
        this.extraBO = extraBO;
    }

    public Extra addExtra(Extra extra) {
        return extraBO.addExtra(extra);
    }
}
